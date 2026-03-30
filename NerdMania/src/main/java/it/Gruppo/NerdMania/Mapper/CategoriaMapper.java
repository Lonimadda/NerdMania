package it.Gruppo.NerdMania.Mapper;


import it.Gruppo.NerdMania.DTO.CategoriaDto;
import it.Gruppo.NerdMania.Modelli.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper extends AbstractConverter<Categoria, CategoriaDto> {

    final private ModelMapper mapper = new ModelMapper();

    @Override
    public CategoriaDto toDTO (Categoria categoria) {return mapper.map(categoria, CategoriaDto.class);}

    @Override
    public Categoria toEntity(CategoriaDto dto) {return mapper.map(dto, Categoria.class);}
}
