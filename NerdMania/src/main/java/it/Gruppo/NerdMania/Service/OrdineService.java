package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.DTO.OrdineDto;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Mapper.OrdineMapper;
import it.Gruppo.NerdMania.Modelli.Ordine;
import it.Gruppo.NerdMania.Repository.OrdineRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdineService extends AbstractService<Ordine, OrdineDto, Integer> {

    private final OrdineMapper ordineMapper;
    private final OrdineRepository ordineRepository;

    public OrdineService(JpaRepository<Ordine, Integer> repository, Converter<Ordine, OrdineDto> converter, OrdineMapper ordineMapper, OrdineRepository ordineRepository) {
        super(repository, converter);
        this.ordineMapper = ordineMapper;
        this.ordineRepository = ordineRepository;
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