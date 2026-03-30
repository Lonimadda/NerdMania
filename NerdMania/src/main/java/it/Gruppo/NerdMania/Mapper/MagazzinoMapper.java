package it.Gruppo.NerdMania.Mapper;

import it.Gruppo.NerdMania.DTO.MagazzinoDto;
import it.Gruppo.NerdMania.Modelli.Magazzino;
import it.Gruppo.NerdMania.Modelli.Prodotto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MagazzinoMapper extends AbstractConverter<Magazzino, MagazzinoDto> {

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public MagazzinoDto toDTO(Magazzino entity) {
        if (entity == null) return null;

        MagazzinoDto dto = mapper.map(entity, MagazzinoDto.class);


        if (entity.getProdotti() != null) {
            List<Long> prodottiId = entity.getProdotti()
                    .stream()
                    .map(Prodotto::getId)
                    .collect(Collectors.toList());
            dto.setProdottiId(prodottiId);
        }

        return dto;
    }

    @Override
    public Magazzino toEntity(MagazzinoDto dto) {
        if (dto == null) return null;

        Magazzino entity = mapper.map(dto, Magazzino.class);


        return entity;
    }
}