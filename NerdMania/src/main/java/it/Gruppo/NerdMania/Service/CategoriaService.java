package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.DTO.CategoriaDto;
import it.Gruppo.NerdMania.Mapper.CategoriaMapper;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Modelli.Categoria;
import it.Gruppo.NerdMania.Repository.CategoriaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService extends AbstractService<Categoria, CategoriaDto, Integer> {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    protected CategoriaService(JpaRepository<Categoria, Integer> repository, Converter<Categoria, CategoriaDto> converter, CategoriaMapper categoriaMapper, CategoriaRepository categoriaRepository) {
        super(repository, converter);
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public boolean existsByNome(String nome){
        return categoriaRepository.existsByNome(nome);
    }

    public List<CategoriaDto> findByNomeContainingIgnoreCase(String nome){
        return categoriaMapper.toDTOList(categoriaRepository.findByNomeContainingIgnoreCase(nome));
    }

    public List<CategoriaDto> findAllByOrderByNomeAsc(){
        return categoriaMapper.toDTOList(categoriaRepository.findAllByOrderByNomeAsc());
    }
}

