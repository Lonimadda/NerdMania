package it.Gruppo.NerdMania.Mapper;

import it.Gruppo.NerdMania.DTO.MagazzinoDto;
import it.Gruppo.NerdMania.Modelli.Magazzino;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

// Indica che la classe è un componente Spring (gestito automaticamente)
@Component
public class MagazzinoMapper extends AbstractConverter<Magazzino, MagazzinoDto> {

    // Oggetto utilizzato per il mapping automatico tra classi
    private final ModelMapper mapper = new ModelMapper();

    // Metodo per convertire da Entity (Magazzino) a DTO (MagazzinoDto)
    public MagazzinoDto toDTO(Magazzino entity) {
        // Mappa automaticamente i campi con lo stesso nome
        return mapper.map(entity, MagazzinoDto.class);
    }

    // Metodo per convertire da DTO (MagazzinoDto) a Entity (Magazzino)
    @Override
    public Magazzino toEntity(MagazzinoDto dto) {
        // Converte il DTO in entità per operazioni sul database
        return mapper.map(dto, Magazzino.class);
    }
}