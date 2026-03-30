package it.Gruppo.NerdMania.Mapper;

import it.Gruppo.NerdMania.DTO.ProdottoDto;
import it.Gruppo.NerdMania.Modelli.Prodotto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProdottoMapper extends AbstractConverter<Prodotto, ProdottoDto> {

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public ProdottoDto toDTO(Prodotto entity) {
        return mapper.map(entity, ProdottoDto.class);
    }

    @Override
    public Prodotto toEntity(ProdottoDto dto) {
        return mapper.map(dto, Prodotto.class);
    }
}