package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.DTO.CarrelloDto;
import it.Gruppo.NerdMania.Mapper.CarrelloMapper;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Modelli.Carrello;
import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Repository.CarrelloRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarrelloService extends AbstractService<Carrello, CarrelloDto> {

    private final CarrelloMapper carrelloMapper;
    private final CarrelloRepository carrelloRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public CarrelloService(
            CarrelloRepository repository,
            Converter<Carrello, CarrelloDto> converter,
            CarrelloMapper carrelloMapper
    ) {
        super(repository, converter);
        this.carrelloMapper = carrelloMapper;
        this.carrelloRepository = repository;
    }

    @Override
    public CarrelloDto insert(CarrelloDto dto) {
        Carrello entity = converter.toEntity(dto);

        // FIX CHIAVE: insert deve avere id null, mai 0
        entity.setId(null);

        normalizeBeforeSave(entity);
        Carrello saved = carrelloRepository.save(entity);
        return converter.toDTO(saved);
    }

    @Override
    public CarrelloDto update(CarrelloDto dto) {
        Carrello entity = converter.toEntity(dto);

        if (entity.getId() == null || entity.getId() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id carrello non valido per update");
        }

        normalizeBeforeSave(entity);
        Carrello saved = carrelloRepository.save(entity);
        return converter.toDTO(saved);
    }

    private void normalizeBeforeSave(Carrello entity) {
        if (entity.getPrezzoTotale() == null) entity.setPrezzoTotale(0.0);
        if (entity.getQuantita() == null) entity.setQuantita(0);
        if (entity.getPeso() == null) entity.setPeso(0.0);

        Integer userId = entity.getUser() != null ? entity.getUser().getId() : null;
        if (userId == null || userId <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Utente obbligatorio per il carrello");
        }

        User managedUser = entityManager.find(User.class, userId);
        if (managedUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato");
        }
        entity.setUser(managedUser);
    }

    // Carrello dell’utente
    public CarrelloDto findByUser(Integer userId) {
        User userRef = new User();
        userRef.setId(userId);

        return carrelloRepository.findByUser(userRef)
                .map(carrelloMapper::toDTO)
                .orElse(null);
    }

    public List<CarrelloDto> findCarrelliAttivi() {
        return carrelloRepository.findByOrdineIsNull()
                .stream()
                .map(carrelloMapper::toDTO)
                .toList();
    }

    public List<CarrelloDto> findByPrezzoTotaleGreaterThan(Double prezzo) {
        return carrelloRepository.findByPrezzoTotaleGreaterThan(prezzo)
                .stream()
                .map(carrelloMapper::toDTO)
                .toList();
    }

    public List<CarrelloDto> findByQuantitaGreaterThan(Integer quantita) {
        return carrelloRepository.findByQuantitaGreaterThan(quantita)
                .stream()
                .map(carrelloMapper::toDTO)
                .toList();
    }

    public List<CarrelloDto> findByPesoLessThan(Double peso) {
        return carrelloRepository.findByPesoLessThan(peso)
                .stream()
                .map(carrelloMapper::toDTO)
                .toList();
    }
}