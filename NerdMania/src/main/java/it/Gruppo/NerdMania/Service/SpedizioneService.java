package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.DTO.SpedizioneDto;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Mapper.SpedizioneMapper;
import it.Gruppo.NerdMania.Modelli.Spedizione;
import it.Gruppo.NerdMania.Repository.SpedizioneRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpedizioneService extends AbstractService<Spedizione, SpedizioneDto> {

    private final SpedizioneMapper spedizioneMapper;
    private final SpedizioneRepository spedizioneRepository;

    public SpedizioneService(JpaRepository<Spedizione, Integer> repository, Converter<Spedizione, SpedizioneDto> converter, SpedizioneMapper spedizioneMapper, SpedizioneRepository spedizioneRepository) {
        super(repository, converter);
        this.spedizioneMapper = spedizioneMapper;
        this.spedizioneRepository = spedizioneRepository;
    }

    public List<SpedizioneDto> findByFragileTrue() {
        return spedizioneMapper.toDTOList(spedizioneRepository.findByFragileTrue());
    }

    public List<SpedizioneDto> findByEsteroTrue() {
        return spedizioneMapper.toDTOList(spedizioneRepository.findByEsteroTrue());
    }

    public List<SpedizioneDto> findByPesoGreaterThan(float peso) {
        return spedizioneMapper.toDTOList(spedizioneRepository.findByPesoGreaterThan(peso));
    }

    public List<SpedizioneDto> findByPesoLessThan(float peso) {
        return spedizioneMapper.toDTOList(spedizioneRepository.findByPesoLessThan(peso));
    }

    public List<SpedizioneDto> findByAltezzaBetween(float min, float max) {
        return spedizioneMapper.toDTOList(spedizioneRepository.findByAltezzaBetween(min,max));
    }

    public List<SpedizioneDto> findByOrdineId(Integer id) {
        return spedizioneMapper.toDTOList(spedizioneRepository.findByOrdineId(id));
    }
    public List<SpedizioneDto> findByAltezzaGreaterThanOrLunghezzaGreaterThan(float h, float l) {
        return spedizioneMapper.toDTOList(spedizioneRepository.findByAltezzaGreaterThanOrLunghezzaGreaterThan(h,l));
    }
}
