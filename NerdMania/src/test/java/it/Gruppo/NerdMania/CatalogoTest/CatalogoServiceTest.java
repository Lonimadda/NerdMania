package it.Gruppo.NerdMania.CatalogoTest;

import it.Gruppo.NerdMania.DTO.CatalogoDto;
import it.Gruppo.NerdMania.Mapper.CatalogoMapper;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Modelli.Catalogo;
import it.Gruppo.NerdMania.Repository.CatalogoRepository;
import it.Gruppo.NerdMania.Service.CatalogoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatalogoServiceTest {

    @Mock
    private CatalogoRepository catalogoRepository;

    @Mock
    private Converter<Catalogo, CatalogoDto> converter;

    @Mock
    private CatalogoMapper catalogoMapper;

    private CatalogoService catalogoService;

    @BeforeEach
    void setUp() {
        catalogoService = new CatalogoService(catalogoRepository, converter, catalogoMapper, catalogoRepository);
    }

    @Test
    void testFindByNome() {
        Catalogo catalogo = new Catalogo();
        catalogo.setId(1);
        catalogo.setNome("Manga");

        CatalogoDto dto = new CatalogoDto(1L, "Manga", List.of());

        when(catalogoRepository.findByNome("Manga")).thenReturn(Optional.of(catalogo));
        when(catalogoMapper.toDTO(catalogo)).thenReturn(dto);

        CatalogoDto result = catalogoService.findByNome("Manga");

        assertEquals(dto, result);
        verify(catalogoRepository).findByNome("Manga");
        verify(catalogoMapper).toDTO(catalogo);
    }

    @Test
    void testFindByNomeThrowsWhenNotFound() {
        when(catalogoRepository.findByNome("Manga")).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> catalogoService.findByNome("Manga"));

        assertEquals("Catalogo non trovato: Manga", exception.getMessage());
        verify(catalogoRepository).findByNome("Manga");
    }

    @Test
    void testExistsByNome() {
        when(catalogoRepository.existsByNome("Manga")).thenReturn(true);

        boolean result = catalogoService.existsByNome("Manga");

        assertTrue(result);
        verify(catalogoRepository).existsByNome("Manga");
    }

    @Test
    void testFindByNomeContaining() {
        Catalogo catalogo1 = new Catalogo();
        catalogo1.setId(1);
        Catalogo catalogo2 = new Catalogo();
        catalogo2.setId(2);

        CatalogoDto dto1 = new CatalogoDto(1L, "Manga", List.of());
        CatalogoDto dto2 = new CatalogoDto(2L, "Super Manga", List.of());

        when(catalogoRepository.findByNomeContaining("Manga")).thenReturn(List.of(catalogo1, catalogo2));
        when(catalogoMapper.toDTO(catalogo1)).thenReturn(dto1);
        when(catalogoMapper.toDTO(catalogo2)).thenReturn(dto2);

        List<CatalogoDto> result = catalogoService.findByNomeContaining("Manga");

        assertEquals(2, result.size());
        assertEquals(dto1, result.get(0));
        assertEquals(dto2, result.get(1));
        verify(catalogoRepository).findByNomeContaining("Manga");
        verify(catalogoMapper).toDTO(catalogo1);
        verify(catalogoMapper).toDTO(catalogo2);
    }

    @Test
    void testFindByNomeStartingWith() {
        Catalogo catalogo = new Catalogo();
        catalogo.setId(3);

        CatalogoDto dto = new CatalogoDto(3L, "Game Pass", List.of());

        when(catalogoRepository.findByNomeStartingWith("Game")).thenReturn(List.of(catalogo));
        when(catalogoMapper.toDTO(catalogo)).thenReturn(dto);

        List<CatalogoDto> result = catalogoService.findByNomeStartingWith("Game");

        assertEquals(1, result.size());
        assertEquals(dto, result.getFirst());
        verify(catalogoRepository).findByNomeStartingWith("Game");
        verify(catalogoMapper).toDTO(catalogo);
    }

    @Test
    void testFindByNomeEndingWith() {
        Catalogo catalogo = new Catalogo();
        catalogo.setId(4);

        CatalogoDto dto = new CatalogoDto(4L, "Action Figure", List.of());

        when(catalogoRepository.findByNomeEndingWith("Figure")).thenReturn(List.of(catalogo));
        when(catalogoMapper.toDTO(catalogo)).thenReturn(dto);

        List<CatalogoDto> result = catalogoService.findByNomeEndingWith("Figure");

        assertEquals(1, result.size());
        assertEquals(dto, result.getFirst());
        verify(catalogoRepository).findByNomeEndingWith("Figure");
        verify(catalogoMapper).toDTO(catalogo);
    }

    @Test
    void testFindCataloghiConCategorie() {
        Catalogo catalogo = new Catalogo();
        catalogo.setId(5);

        CatalogoDto dto = new CatalogoDto(5L, "Anime", List.of());

        when(catalogoRepository.findByCategorieIsNotNull()).thenReturn(List.of(catalogo));
        when(catalogoMapper.toDTO(catalogo)).thenReturn(dto);

        List<CatalogoDto> result = catalogoService.findCataloghiConCategorie();

        assertEquals(1, result.size());
        assertEquals(dto, result.getFirst());
        verify(catalogoRepository).findByCategorieIsNotNull();
        verify(catalogoMapper).toDTO(catalogo);
    }

    @Test
    void testFindCataloghiSenzaCategorie() {
        Catalogo catalogo = new Catalogo();
        catalogo.setId(6);

        CatalogoDto dto = new CatalogoDto(6L, "Vuoto", List.of());

        when(catalogoRepository.findByCategorieIsNull()).thenReturn(List.of(catalogo));
        when(catalogoMapper.toDTO(catalogo)).thenReturn(dto);

        List<CatalogoDto> result = catalogoService.findCataloghiSenzaCategorie();

        assertEquals(1, result.size());
        assertEquals(dto, result.getFirst());
        verify(catalogoRepository).findByCategorieIsNull();
        verify(catalogoMapper).toDTO(catalogo);
    }

    @Test
    void testFindByNumeroCategorieGreaterThan() {
        Catalogo catalogo = new Catalogo();
        catalogo.setId(7);

        CatalogoDto dto = new CatalogoDto(7L, "Completo", List.of());

        when(catalogoRepository.findByNumeroCategorieGreaterThan(3)).thenReturn(List.of(catalogo));
        when(catalogoMapper.toDTO(catalogo)).thenReturn(dto);

        List<CatalogoDto> result = catalogoService.findByNumeroCategorieGreaterThan(3);

        assertEquals(1, result.size());
        assertEquals(dto, result.getFirst());
        verify(catalogoRepository).findByNumeroCategorieGreaterThan(3);
        verify(catalogoMapper).toDTO(catalogo);
    }
}
