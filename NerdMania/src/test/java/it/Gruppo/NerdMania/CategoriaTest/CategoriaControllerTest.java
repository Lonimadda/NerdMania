package it.Gruppo.NerdMania.CategoriaTest;

import it.Gruppo.NerdMania.Controller.CategoriaController;
import it.Gruppo.NerdMania.DTO.CategoriaDto;
import it.Gruppo.NerdMania.Service.CategoriaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoriaControllerTest {

    @Mock
    private CategoriaService service;

    @InjectMocks
    private CategoriaController controller;

    
    // existsByNome
    

    @Test
    public void existsByNome_true() {

        String nome = "Anime";

        when(service.existsByNome(nome)).thenReturn(true);

        boolean result = controller.existsByNome(nome);

        assertTrue(result);
    }

    @Test
    public void existsByNome_false() {

        String nome = "NonEsiste";

        when(service.existsByNome(nome)).thenReturn(false);

        boolean result = controller.existsByNome(nome);

        assertFalse(result);
    }

    @Test
    public void existsByNome_null() {

        when(service.existsByNome(null)).thenReturn(false);

        boolean result = controller.existsByNome(null);

        assertFalse(result);
    }

    
    // findByNomeContainingIgnoreCase
    

    @Test
    public void findByNomeContainingIgnoreCase_found() {

        CategoriaDto dto = new CategoriaDto();
        dto.setNome("Anime");

        List<CategoriaDto> lista = new ArrayList<>();
        lista.add(dto);

        when(service.findByNomeContainingIgnoreCase("ani"))
                .thenReturn(lista);

        List<CategoriaDto> result =
                controller.findByNomeContainingIgnoreCase("ani");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Anime", result.getFirst().getNome());
    }

    @Test
    public void findByNomeContainingIgnoreCase_empty() {

        List<CategoriaDto> lista = new ArrayList<>();

        when(service.findByNomeContainingIgnoreCase("xyz"))
                .thenReturn(lista);

        List<CategoriaDto> result =
                controller.findByNomeContainingIgnoreCase("xyz");

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void findByNomeContainingIgnoreCase_null() {

        when(service.findByNomeContainingIgnoreCase(null))
                .thenReturn(new ArrayList<>());

        List<CategoriaDto> result =
                controller.findByNomeContainingIgnoreCase(null);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    
    // findAllByOrderByNomeAsc
    

    @Test
    public void findAllByOrderByNomeAsc_success() {

        CategoriaDto c1 = new CategoriaDto();
        c1.setNome("Anime");

        CategoriaDto c2 = new CategoriaDto();
        c2.setNome("Marvel");

        List<CategoriaDto> lista = new ArrayList<>();
        lista.add(c1);
        lista.add(c2);

        when(service.findAllByOrderByNomeAsc())
                .thenReturn(lista);

        List<CategoriaDto> result =
                controller.findAllByOrderByNomeAsc();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Anime", result.getFirst().getNome());
    }

    @Test
    public void findAllByOrderByNomeAsc_empty() {

        when(service.findAllByOrderByNomeAsc())
                .thenReturn(new ArrayList<>());

        List<CategoriaDto> result =
                controller.findAllByOrderByNomeAsc();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}