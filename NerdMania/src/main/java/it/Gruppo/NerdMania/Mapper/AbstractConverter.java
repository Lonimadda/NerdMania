package it.Gruppo.NerdMania.Mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<Entity,DTO> implements Converter<Entity,DTO> {

    public List<Entity> toEntityList(Iterable<DTO> listDTO) {
        List<Entity> list = new ArrayList<>();

        if(listDTO != null) {
            for(DTO dto : listDTO) {
                Entity entity = toEntity(dto);
                list.add(entity);
            }
        }
        return list;
    }

    public List<DTO> toDTOList(Iterable<Entity> listEntity) {
        List<DTO> list = new ArrayList<>();
        if(listEntity != null) {
            for(Entity entity : listEntity) {
                DTO dto = toDTO(entity);
                list.add(dto);
            }
        }
        return list;
    }
}
