package it.Gruppo.NerdMania.Service;


import it.Gruppo.NerdMania.DTO.CarrelloDto;
import it.Gruppo.NerdMania.Mapper.CarrelloMapper;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Modelli.Carrello;
import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Repository.CarrelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrelloService extends AbstractService<Carrello, CarrelloDto>{        //LorenzoLombardi

    private final CarrelloMapper carrelloMapper;
    private final CarrelloRepository carrelloRepository;

    @Autowired
    public CarrelloService(CarrelloRepository repository,
                           Converter<Carrello, CarrelloDto> converter,
                           CarrelloMapper carrelloMapper,
                           CarrelloRepository carrelloRepository) {
        super(repository, converter);
        this.carrelloMapper = carrelloMapper;
        this.carrelloRepository = carrelloRepository;
    }

    //Carrello dell’utente (oggetto)
    public CarrelloDto findByUser(User user) {
        return carrelloMapper.toDTO(
                carrelloRepository.findByUser(user)
                        .orElseThrow(() -> new RuntimeException("Carrello non trovato per l'utente"))
        );
    }

    //Tutti i carrelli attivi
    public List<CarrelloDto> findCarrelliAttivi() {
        return carrelloRepository.findByOrdineIsNull()
                .stream()
                .map(carrelloMapper::toDTO)
                .toList();
    }

    //Carrelli sopra una certa soglia di prezzo
    public List<CarrelloDto> findByPrezzoTotaleGreaterThan(Double prezzo) {
        return carrelloRepository.findByPrezzoTotaleGreaterThan(prezzo)
                .stream()
                .map(carrelloMapper::toDTO)
                .toList();
    }

    //Carrelli con quantità maggiore di X
    public List<CarrelloDto> findByQuantitaGreaterThan(Integer quantita) {
        return carrelloRepository.findByQuantitaGreaterThan(quantita)
                .stream()
                .map(carrelloMapper::toDTO)
                .toList();
    }

    //Carrelli leggeri (spedizioni)
    public List<CarrelloDto> findByPesoLessThan(Double peso) {
        return carrelloRepository.findByPesoLessThan(peso)
                .stream()
                .map(carrelloMapper::toDTO)
                .toList();
    }
}