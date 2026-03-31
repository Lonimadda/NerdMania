package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.Mapper.Converter;
import org.springframework.data.jpa.repository.JpaRepository;



public abstract class AbstractService<ENTITY, DTO> implements ServiceDTO<DTO> {

    protected JpaRepository<ENTITY, Integer> repository;
    protected Converter<ENTITY, DTO> converter;

    public AbstractService(JpaRepository<ENTITY, Integer> repository, Converter<ENTITY, DTO> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public DTO insert (DTO dto){
        return converter.toDTO(repository.save(converter.toEntity(dto)));
    }

    @Override
    public DTO update (DTO dto){
        return converter.toDTO(repository.save(converter.toEntity(dto)));
    }

    @Override
    public Iterable<DTO> getAll(){
        return converter.toDTOList(repository.findAll());
    }

    @Override
    public DTO read (Integer id){
        return converter.toDTO(repository.findById(id).get());
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
