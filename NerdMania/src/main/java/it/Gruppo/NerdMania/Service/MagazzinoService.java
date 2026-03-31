package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.DTO.MagazzinoDto;
import it.Gruppo.NerdMania.Mapper.MagazzinoMapper;
import it.Gruppo.NerdMania.Modelli.Magazzino;
import it.Gruppo.NerdMania.Repository.MagazzinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagazzinoService extends AbstractService<Magazzino, MagazzinoDto, Long> {

    private final MagazzinoRepository magazzinoRepository;
    private final MagazzinoMapper magazzinoMapper;

    public MagazzinoService(MagazzinoRepository magazzinoRepository,
                            MagazzinoMapper magazzinoMapper) {

        super(magazzinoRepository, magazzinoMapper);
        this.magazzinoRepository = magazzinoRepository;
        this.magazzinoMapper = magazzinoMapper;
    }

    public List<MagazzinoDto> search(String keyword) {
        return magazzinoMapper.toDTOList(
                magazzinoRepository.search(keyword)
        );
    }

    public List<MagazzinoDto> findMagazziniConScorteBasse(int soglia) {
        return magazzinoMapper.toDTOList(
                magazzinoRepository.findMagazziniConScorteBasse(soglia)
        );
    }

    public List<MagazzinoDto> findMagazziniConScorteAlte(int soglia) {
        return magazzinoMapper.toDTOList(
                magazzinoRepository.findMagazziniConScorteAlte(soglia)
        );
    }

    public MagazzinoDto findByCodice(String codice) {
        return magazzinoMapper.toDTO(
                magazzinoRepository.findByCodice(codice)
        );
    }

    public List<MagazzinoDto> findMagazziniByProdottoId(Long prodottoId) {
        return magazzinoMapper.toDTOList(
                magazzinoRepository.findMagazziniByProdottoId(prodottoId)
        );
    }

    public List<MagazzinoDto> findMagazziniByNomeProdotto(String nomeProdotto) {
        return magazzinoMapper.toDTOList(
                magazzinoRepository.findMagazziniByNomeProdotto(nomeProdotto)
        );
    }
}