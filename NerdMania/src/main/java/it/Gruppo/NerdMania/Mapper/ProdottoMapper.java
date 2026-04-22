package it.Gruppo.NerdMania.Mapper;

import it.Gruppo.NerdMania.DTO.ProdottoDto;
import it.Gruppo.NerdMania.Modelli.Prodotto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

// Indica che questa classe è un componente Spring (gestito dal container)
@Component
public class ProdottoMapper extends AbstractConverter<Prodotto, ProdottoDto> {

    // Istanza di ModelMapper usata per mappare automaticamente i campi
    private final ModelMapper mapper = new ModelMapper();

    // Metodo per convertire da Entity (Prodotto) a DTO (ProdottoDto)
    @Override
    public ProdottoDto toDTO(Prodotto entity) {
        // Mappa automaticamente i campi con lo stesso nome
        return mapper.map(entity, ProdottoDto.class);
    }

    // Metodo per convertire da DTO (ProdottoDto) a Entity (Prodotto)
    @Override
    public Prodotto toEntity(ProdottoDto dto) {
        // Converte il DTO in entità per operazioni di persistenza
        return mapper.map(dto, Prodotto.class);
    }
}