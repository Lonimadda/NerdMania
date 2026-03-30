package it.Gruppo.NerdMania.Mapper;


import it.Gruppo.NerdMania.DTO.CatalogoDto;
import it.Gruppo.NerdMania.Modelli.Catalogo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CatalogoMapper extends AbstractConverter<Catalogo, CatalogoDto> {


    //modelmapper usato per mappare automaticamente
    final private ModelMapper mapper = new ModelMapper();

    // converte entità Auto in DTO AutoDto
    @Override
    public CatalogoDto toDTO(Catalogo entity) { return mapper.map(entity, CatalogoDto.class); }

    //converte DTO AutoDto in entità Auto
    @Override
    public Catalogo toEntity(CatalogoDto dto) { return mapper.map(dto, Catalogo.class);} }