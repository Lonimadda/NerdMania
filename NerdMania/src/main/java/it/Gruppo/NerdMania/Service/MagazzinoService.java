package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.DTO.MagazzinoDto;
import it.Gruppo.NerdMania.DTO.UserDto;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Mapper.MagazzinoMapper;
import it.Gruppo.NerdMania.Mapper.UserMapper;
import it.Gruppo.NerdMania.Modelli.Magazzino;
import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Repository.MagazzinoRepository;
import it.Gruppo.NerdMania.Repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagazzinoService extends AbstractService<Magazzino, MagazzinoDto> {

    private final MagazzinoRepository magazzinoRepository;
    private final MagazzinoMapper magazzinoMapper;

    public MagazzinoService(JpaRepository<Magazzino, Integer> repository, Converter<Magazzino, MagazzinoDto> converter, MagazzinoMapper magazzinoMapper, MagazzinoRepository magazzinoRepository) {
        super(repository, converter);
        this.magazzinoMapper = magazzinoMapper;
        this.magazzinoRepository = magazzinoRepository;
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