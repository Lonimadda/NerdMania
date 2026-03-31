package it.Gruppo.NerdMania.Mapper;

import it.Gruppo.NerdMania.DTO.MagazzinoDto;
import it.Gruppo.NerdMania.DTO.OrdineDto;
import it.Gruppo.NerdMania.Modelli.Magazzino;
import it.Gruppo.NerdMania.Modelli.Ordine;
import it.Gruppo.NerdMania.Modelli.Prodotto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MagazzinoMapper extends AbstractConverter<Magazzino, MagazzinoDto> {

    private final ModelMapper mapper = new ModelMapper();

    public MagazzinoDto toDTO(Magazzino entity) { return mapper.map(entity, MagazzinoDto.class); }

    @Override
    public Magazzino toEntity(MagazzinoDto dto) { return mapper.map(dto, Magazzino.class);}

}