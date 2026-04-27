package it.Gruppo.NerdMania.CatalogoTest;

import it.Gruppo.NerdMania.Controller.CatalogoController;
import it.Gruppo.NerdMania.DTO.CatalogoDto;
import it.Gruppo.NerdMania.Service.CatalogoService;
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
class CatalogoControllerTest {

    @Mock
    private CatalogoService catalogoService;

    @InjectMocks
    private CatalogoController catalogoController;

    @Test
    void testFindByNome_found() {

        CatalogoDto dto =
                new CatalogoDto(1L, "Manga", List.of());

        when(catalogoService.findByNome("Manga"))
                .thenReturn(dto);

        CatalogoDto result =
                catalogoController.findByNome("Manga");

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Manga", result.getNome());
        assertNotNull(result.getCategorie());
        assertEquals(0, result.getCategorie().size());

        verify(catalogoService).findByNome("Manga");
    }

    @Test
    void testExistsByNome_true() {

        when(catalogoService.existsByNome("Manga"))
                .thenReturn(true);

        boolean result =
                catalogoController.existsByNome("Manga");

        assertTrue(result);

        verify(catalogoService).existsByNome("Manga");
    }

    @Test
    void testExistsByNome_false() {

        when(catalogoService.existsByNome("XYZ"))
                .thenReturn(false);

        boolean result =
                catalogoController.existsByNome("XYZ");

        assertFalse(result);

        verify(catalogoService).existsByNome("XYZ");
    }

    @Test
    void testFindByNomeContaining_found() {

        List<CatalogoDto> lista = List.of(
                new CatalogoDto(1L, "Manga", List.of()),
                new CatalogoDto(2L, "Super Manga", List.of())
        );

        when(catalogoService.findByNomeContaining("Manga"))
                .thenReturn(lista);

        List<CatalogoDto> result =
                catalogoController.findByNomeContaining("Manga");

        assertNotNull(result);
        assertEquals(2, result.size());

        assertEquals("Manga", result.get(0).getNome());
        assertEquals("Super Manga", result.get(1).getNome());

        verify(catalogoService).findByNomeContaining("Manga");
    }

    @Test
    void testFindByNomeContaining_empty() {

        when(catalogoService.findByNomeContaining("xyz"))
                .thenReturn(List.of());

        List<CatalogoDto> result =
                catalogoController.findByNomeContaining("xyz");

        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(catalogoService).findByNomeContaining("xyz");
    }

    @Test
    void testFindByNomeStartingWith_found() {

        List<CatalogoDto> lista = List.of(
                new CatalogoDto(3L, "Game Pass", List.of())
        );

        when(catalogoService.findByNomeStartingWith("Game"))
                .thenReturn(lista);

        List<CatalogoDto> result =
                catalogoController.findByNomeStartingWith("Game");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Game Pass", result.getFirst().getNome());

        verify(catalogoService).findByNomeStartingWith("Game");
    }

    @Test
    void testFindByNomeEndingWith_found() {

        List<CatalogoDto> lista = List.of(
                new CatalogoDto(4L, "Action Figure", List.of())
        );

        when(catalogoService.findByNomeEndingWith("Figure"))
                .thenReturn(lista);

        List<CatalogoDto> result =
                catalogoController.findByNomeEndingWith("Figure");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Action Figure", result.getFirst().getNome());

        verify(catalogoService).findByNomeEndingWith("Figure");
    }

    @Test
    void testFindCataloghiConCategorie_found() {

        List<CatalogoDto> lista = List.of(
                new CatalogoDto(5L, "Anime", List.of())
        );

        when(catalogoService.findCataloghiConCategorie())
                .thenReturn(lista);

        List<CatalogoDto> result =
                catalogoController.findCataloghiConCategorie();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Anime", result.getFirst().getNome());

        verify(catalogoService).findCataloghiConCategorie();
    }

    @Test
    void testFindCataloghiSenzaCategorie_found() {

        List<CatalogoDto> lista = List.of(
                new CatalogoDto(6L, "Vuoto", List.of())
        );

        when(catalogoService.findCataloghiSenzaCategorie())
                .thenReturn(lista);

        List<CatalogoDto> result =
                catalogoController.findCataloghiSenzaCategorie();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Vuoto", result.getFirst().getNome());

        verify(catalogoService).findCataloghiSenzaCategorie();
    }

    @Test
    void testFindByNumeroCategorieGreaterThan_found() {

        List<CatalogoDto> lista = List.of(
                new CatalogoDto(7L, "Completo", List.of())
        );

        when(catalogoService
                .findByNumeroCategorieGreaterThan(3))
                .thenReturn(lista);

        List<CatalogoDto> result =
                catalogoController
                        .findByNumeroCategorieGreaterThan(3);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Completo", result.getFirst().getNome());

        verify(catalogoService)
                .findByNumeroCategorieGreaterThan(3);
    }

}