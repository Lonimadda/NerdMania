package it.Gruppo.NerdMania.Service;

import it.Gruppo.NerdMania.Mapper.Converter;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<ENTITY, DTO, ID> implements ServiceDTO<DTO, ID> {

    protected JpaRepository<ENTITY, ID> repository;
    protected Converter<ENTITY, DTO> converter;

    public AbstractService(JpaRepository<ENTITY, ID> repository, Converter<ENTITY, DTO> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public DTO insert(DTO dto) {
        return converter.toDTO(repository.save(converter.toEntity(dto)));
    }

    @Override
    public DTO update(DTO dto) {
        return converter.toDTO(repository.save(converter.toEntity(dto)));
    }

    @Override
    public Iterable<DTO> getAll() {
        return converter.toDTOList(repository.findAll());
    }

    @Override
    public DTO read(ID id) {
        return converter.toDTO(repository.findById(id).orElse(null));
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}