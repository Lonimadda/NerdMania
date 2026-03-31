package it.Gruppo.NerdMania.Service;

public interface ServiceDTO<DTO, ID> {

    DTO insert(DTO dto);

    DTO update(DTO dto);

    Iterable<DTO> getAll();

    DTO read(ID id);

    void delete(ID id);
}