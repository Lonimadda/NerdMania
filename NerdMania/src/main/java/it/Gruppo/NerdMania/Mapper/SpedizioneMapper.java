package it.Gruppo.NerdMania.Mapper;

import it.Gruppo.NerdMania.DTO.SpedizioneDto;
import it.Gruppo.NerdMania.Modelli.Spedizione;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SpedizioneMapper extends AbstractConverter<Spedizione, SpedizioneDto> {

    final private ModelMapper mapper = new ModelMapper();

    @Override
    public SpedizioneDto toDTO(Spedizione entity) { return mapper.map(entity, SpedizioneDto.class); }

    @Override
    public Spedizione toEntity(SpedizioneDto dto) { return mapper.map(dto, Spedizione.class);}
}
