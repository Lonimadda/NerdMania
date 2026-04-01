package it.Gruppo.NerdMania.CategoriaTest;


import it.Gruppo.NerdMania.Controller.CategoriaController;
import it.Gruppo.NerdMania.DTO.CategoriaDto;
import it.Gruppo.NerdMania.Mapper.CategoriaMapper;
import it.Gruppo.NerdMania.Modelli.Categoria;
import it.Gruppo.NerdMania.Repository.CategoriaRepository;
import it.Gruppo.NerdMania.Service.CategoriaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {

    @InjectMocks
    private CategoriaService service;

    @Mock
    private CategoriaRepository repository;

    @Mock
    private CategoriaController controller;

    @Mock
    private CategoriaMapper mapper;



    @Test
    public void existsByNome_false() {
        String categoria = "NonEsiste";

        when(repository.existsByNome(categoria)).thenReturn(false);


        boolean result = service.existsByNome(categoria);

        assertFalse(result);
    }

    @Test
    public void existsByNome_true() {

        String categoria = "Carte";

        when(repository.existsByNome(categoria)).thenReturn(true);

        boolean result = service.existsByNome(categoria);

        assertTrue(result);
    }

    @Test
    public void existsByNome_null() {

        when(repository.existsByNome(null)).thenReturn(false);
        boolean result = service.existsByNome(null);
        assertFalse(result);
        verify(repository).existsByNome(null);
    }


    @Test
    public void findByNomeContainingIgnoreCase_found(){
        Categoria categoria = new Categoria();
        categoria.setNome("Carte");
        Categoria categoria2 = new Categoria();
        categoria2.setNome("Calcio");

        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setNome("Carte");
        CategoriaDto categoriaDto2 = new CategoriaDto();
        categoriaDto2.setNome("Calcio");

        List<Categoria> categorias = List.of(categoria,categoria2);
        List<CategoriaDto> categoriaDtos = List.of(categoriaDto, categoriaDto2);

        when(repository.findByNomeContainingIgnoreCase("ca")).thenReturn(categorias);
        when(mapper.toDTOList(categorias)).thenReturn(categoriaDtos);

        List<CategoriaDto> result = service.findByNomeContainingIgnoreCase("ca");

        assertNotNull(result);
        assertEquals(categoriaDtos, result);
        assertEquals("Carte", result.get(0).getNome());
        assertEquals("Calcio", result.get(1).getNome());
    }

    @Test
    public void findByNomeContainingIgnoreCase_empty(){
        List<Categoria> categorias = List.of();

        when(repository.findByNomeContainingIgnoreCase("ce")).thenReturn(categorias);
        when(mapper.toDTOList(categorias)).thenReturn(List.of());

        List<CategoriaDto> result = service.findByNomeContainingIgnoreCase("ce");

        assertTrue(result.isEmpty());

    }

    @Test
    public void findAllByOrderByNomeAsc_success() {

        Categoria c1 = new Categoria();
        c1.setNome("Calcio");

        Categoria c2 = new Categoria();
        c2.setNome("Carte");

        List<Categoria> categorias = List.of(c1, c2);

        CategoriaDto dto1 = new CategoriaDto();
        dto1.setNome("Calcio");

        CategoriaDto dto2 = new CategoriaDto();
        dto2.setNome("Carte");

        List<CategoriaDto> categoriaDtos =
                List.of(dto1, dto2);

        when(repository
                .findAllByOrderByNomeAsc())
                .thenReturn(categorias);

        when(mapper
                .toDTOList(categorias))
                .thenReturn(categoriaDtos);

        List<CategoriaDto> result =
                service.findAllByOrderByNomeAsc();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(categoriaDtos, result);

        verify(repository)
                .findAllByOrderByNomeAsc();

        verify(mapper)
                .toDTOList(categorias);
    }

    @Test
    public void findAllByOrderByNomeAsc_empty(){

        List<Categoria> categorias = List.of();

        when(repository
                .findAllByOrderByNomeAsc())
                .thenReturn(categorias);

        when(mapper
                .toDTOList(categorias))
                .thenReturn(List.of());

        List<CategoriaDto> result =
                service.findAllByOrderByNomeAsc();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
