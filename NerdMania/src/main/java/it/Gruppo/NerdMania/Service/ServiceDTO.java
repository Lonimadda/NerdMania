package it.Gruppo.NerdMania.Service;

public interface ServiceDTO<DTO> {

    DTO insert(DTO dto);

    DTO update(DTO dto);

    Iterable<DTO> getAll();

    DTO read(Integer id);

    void delete(Integer id);
}