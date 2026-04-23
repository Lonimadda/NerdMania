package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.DTO.OrdineDto;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Mapper.OrdineMapper;
import it.Gruppo.NerdMania.Modelli.*;
import it.Gruppo.NerdMania.Repository.CarrelloRepository;
import it.Gruppo.NerdMania.Repository.OrdineRepository;
import it.Gruppo.NerdMania.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdineService extends AbstractService<Ordine, OrdineDto>  {

    private final OrdineMapper ordineMapper;
    private final OrdineRepository ordineRepository;
    private final UserRepository userRepository;
    private final CarrelloRepository carrelloRepository;

    @Autowired
    private EmailService emailService;

    public OrdineService(JpaRepository<Ordine, Integer> repository, Converter<Ordine, OrdineDto> converter, OrdineMapper ordineMapper, OrdineRepository ordineRepository, UserRepository userRepository, CarrelloRepository carrelloRepository) {
        super(repository, converter);
        this.ordineMapper = ordineMapper;
        this.ordineRepository = ordineRepository;
        this.userRepository= userRepository;
        this.carrelloRepository=carrelloRepository;
    }

    @Override
    public OrdineDto insert(OrdineDto dto) {

        Ordine ordine = ordineMapper.toEntity(dto);

        // 🔥 RECUPERO USER DAL DB
        Integer userId = dto.getUser().getId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User non trovato"));

        ordine.setUser(user);

        // 🔹 RECUPERO CARRELLO
        Carrello carrello = carrelloRepository.findByUser(user)
                        .orElseThrow(() -> new RuntimeException("User non trovato"));

        // 🔥 COSTO DAL CARRELLO
        ordine.setCostoTotale(carrello.getPrezzoTotale().floatValue());

        // 🔥 CREAZIONE SPEDIZIONE
        Spedizione spedizione = new Spedizione();

        // PESO DAL CARRELLO
        spedizione.setPeso(carrello.getPeso().floatValue());

        // FRAGILE → almeno un prodotto fragile
        boolean fragile = ordine.getProdotti()
                .stream()
                .anyMatch(Prodotto::isFragile);

        spedizione.setFragile(fragile);

        // DIMENSIONI → massimo tra i prodotti
        float altezzaMax = ordine.getProdotti()
                .stream()
                .map(Prodotto::getAltezza)
                .max(Float::compare)
                .orElse(0f);

        float lunghezzaMax = ordine.getProdotti()
                .stream()
                .map(Prodotto::getLunghezza)
                .max(Float::compare)
                .orElse(0f);

        float spessoreMax = ordine.getProdotti()
                .stream()
                .map(Prodotto::getSpessore)
                .max(Float::compare)
                .orElse(0f);

        spedizione.setAltezza(altezzaMax);
        spedizione.setLunghezza(lunghezzaMax);
        spedizione.setSpessore(spessoreMax);

        // 🔗 COLLEGAMENTO BIDIREZIONALE
        spedizione.setOrdine(ordine);
        ordine.setSpedizione(spedizione);

        Ordine salvato = ordineRepository.save(ordine);

        // DATI UTENTE (ora funzionano)
        String email = user.getEmail();
        String username = user.getUsername();

        // INVIO EMAIL
        try {
            emailService.inviaEmailOrdine(email, username, salvato.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ordineMapper.toDTO(salvato);
    }

    public List<OrdineDto> findByUserUsername(String username) {
        return ordineMapper.toDTOList(ordineRepository.findByUserUsername(username));
    }

    public List<OrdineDto> findAllByOrderByCostoTotaleDesc() {
        return ordineMapper.toDTOList(ordineRepository.findAllByOrderByCostoTotaleDesc());
    }

    public List<OrdineDto> findAllByOrderByCostoTotaleAsc() {
        return ordineMapper.toDTOList(ordineRepository.findAllByOrderByCostoTotaleAsc());
    }

    public List<OrdineDto> findByIndirizzoSpedizioneContainingIgnoreCase(String testo) {
        return ordineMapper.toDTOList(ordineRepository.findByIndirizzoSpedizioneContainingIgnoreCase(testo));
    }

    public List<OrdineDto> findByCostoTotaleGreaterThan(float prezzo) {
        return ordineMapper.toDTOList(ordineRepository.findByCostoTotaleGreaterThan(prezzo));
    }

    public List<OrdineDto> findByCostoTotaleLessThan(float prezzo) {
        return ordineMapper.toDTOList(ordineRepository.findByCostoTotaleLessThan(prezzo));
    }

    public List<OrdineDto> findByProdottiId(Integer prodottoId) {
        return ordineMapper.toDTOList(ordineRepository.findByProdottiId(prodottoId));
    }
}