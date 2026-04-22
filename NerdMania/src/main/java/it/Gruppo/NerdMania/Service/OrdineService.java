package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.DTO.OrdineDto;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Mapper.OrdineMapper;
import it.Gruppo.NerdMania.Modelli.Ordine;
import it.Gruppo.NerdMania.Modelli.User;
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

    @Autowired
    private EmailService emailService;


    public OrdineService(JpaRepository<Ordine, Integer> repository, Converter<Ordine, OrdineDto> converter, OrdineMapper ordineMapper, OrdineRepository ordineRepository, UserRepository userRepository) {
        super(repository, converter);
        this.ordineMapper = ordineMapper;
        this.ordineRepository = ordineRepository;
        this.userRepository= userRepository;
    }

    @Override
    public OrdineDto insert(OrdineDto dto) {

        Ordine ordine = ordineMapper.toEntity(dto);

        // 🔥 RECUPERO USER DAL DB
        Integer userId = dto.getUser().getId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User non trovato"));

        ordine.setUser(user);

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