package it.Gruppo.NerdMania.Mapper;

import it.Gruppo.NerdMania.DTO.OrdineDto;
import it.Gruppo.NerdMania.Modelli.Ordine;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrdineMapper extends AbstractConverter<Ordine, OrdineDto> {

    final private ModelMapper mapper = new ModelMapper();

    @Override
    public OrdineDto toDTO(Ordine entity) { return mapper.map(entity, OrdineDto.class); }

    @Override
    public Ordine toEntity(OrdineDto dto) { return mapper.map(dto, Ordine.class);}
}