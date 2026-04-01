package it.Gruppo.NerdMania.CatalogoTest;

import it.Gruppo.NerdMania.Controller.CatalogoController;
import it.Gruppo.NerdMania.DTO.CatalogoDto;
import it.Gruppo.NerdMania.Service.CatalogoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CatalogoController.class)
@AutoConfigureMockMvc(addFilters = false)
class CatalogoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CatalogoService catalogoService;

    @Test
    void testFindByNome() throws Exception {
        CatalogoDto dto = new CatalogoDto(1L, "Manga", List.of());

        when(catalogoService.findByNome("Manga")).thenReturn(dto);

        mockMvc.perform(get("/Catalogo/findByNome")
                        .param("nome", "Manga"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(is(1)))
                .andExpect(jsonPath("$.nome").value(is("Manga")))
                .andExpect(jsonPath("$.categorie").isArray())
                .andExpect(jsonPath("$.categorie.length()").value(is(0)));
    }

    @Test
    void testExistsByNome() throws Exception {
        when(catalogoService.existsByNome("Manga")).thenReturn(true);

        mockMvc.perform(get("/Catalogo/existsByNome")
                        .param("nome", "Manga"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(is(true)));
    }

    @Test
    void testFindByNomeContaining() throws Exception {
        List<CatalogoDto> lista = List.of(
                new CatalogoDto(1L, "Manga", List.of()),
                new CatalogoDto(2L, "Super Manga", List.of())
        );

        when(catalogoService.findByNomeContaining("Manga")).thenReturn(lista);

        mockMvc.perform(get("/Catalogo/findByNomeContaining")
                        .param("nome", "Manga"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(is(1)))
                .andExpect(jsonPath("$[0].nome").value(is("Manga")))
                .andExpect(jsonPath("$[1].id").value(is(2)))
                .andExpect(jsonPath("$[1].nome").value(is("Super Manga")));
    }

    @Test
    void testFindByNomeStartingWith() throws Exception {
        List<CatalogoDto> lista = List.of(
                new CatalogoDto(3L, "Game Pass", List.of())
        );

        when(catalogoService.findByNomeStartingWith("Game")).thenReturn(lista);

        mockMvc.perform(get("/Catalogo/findByNomeStartingWith")
                        .param("nome", "Game"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(is(3)))
                .andExpect(jsonPath("$[0].nome").value(is("Game Pass")));
    }

    @Test
    void testFindByNomeEndingWith() throws Exception {
        List<CatalogoDto> lista = List.of(
                new CatalogoDto(4L, "Action Figure", List.of())
        );

        when(catalogoService.findByNomeEndingWith("Figure")).thenReturn(lista);

        mockMvc.perform(get("/Catalogo/findByNomeEndingWith")
                        .param("nome", "Figure"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(is(4)))
                .andExpect(jsonPath("$[0].nome").value(is("Action Figure")));
    }

    @Test
    void testFindCataloghiConCategorie() throws Exception {
        List<CatalogoDto> lista = List.of(
                new CatalogoDto(5L, "Anime", List.of())
        );

        when(catalogoService.findCataloghiConCategorie()).thenReturn(lista);

        mockMvc.perform(get("/Catalogo/findCataloghiConCategorie"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(is(5)))
                .andExpect(jsonPath("$[0].nome").value(is("Anime")));
    }

    @Test
    void testFindCataloghiSenzaCategorie() throws Exception {
        List<CatalogoDto> lista = List.of(
                new CatalogoDto(6L, "Vuoto", List.of())
        );

        when(catalogoService.findCataloghiSenzaCategorie()).thenReturn(lista);

        mockMvc.perform(get("/Catalogo/findCataloghiSenzaCategorie"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(is(6)))
                .andExpect(jsonPath("$[0].nome").value(is("Vuoto")));
    }

    @Test
    void testFindByNumeroCategorieGreaterThan() throws Exception {
        List<CatalogoDto> lista = List.of(
                new CatalogoDto(7L, "Completo", List.of())
        );

        when(catalogoService.findByNumeroCategorieGreaterThan(3)).thenReturn(lista);

        mockMvc.perform(get("/Catalogo/findByNumeroCategorieGreaterThan")
                        .param("size", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(is(7)))
                .andExpect(jsonPath("$[0].nome").value(is("Completo")));
    }
}
