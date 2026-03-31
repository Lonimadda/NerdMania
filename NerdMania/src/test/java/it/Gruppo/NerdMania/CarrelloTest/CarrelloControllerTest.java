package it.Gruppo.NerdMania.CarrelloTest;

import it.Gruppo.NerdMania.Controller.CarrelloController;
import it.Gruppo.NerdMania.DTO.CarrelloDto;
import it.Gruppo.NerdMania.Service.CarrelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarrelloController.class)
@AutoConfigureMockMvc(addFilters = false)
class CarrelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CarrelloService carrelloService;

    @Test
    void testFindByUser() throws Exception {
        CarrelloDto dto = new CarrelloDto(1, 50.0, 3, 1.2);

        when(carrelloService.findByUser(org.mockito.ArgumentMatchers.any()))
                .thenReturn(dto);

        mockMvc.perform(get("/Carrello/findByUser")
                        .param("username", "lorenzo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(is(1)))
                .andExpect(jsonPath("$.prezzoTotale").value(closeTo(50.0, 0.001)))
                .andExpect(jsonPath("$.quantita").value(is(3)))
                .andExpect(jsonPath("$.peso").value(closeTo(1.2, 0.001)));
    }

    @Test
    void testFindCarrelliAttivi() throws Exception {
        List<CarrelloDto> lista = List.of(
                new CarrelloDto(1, 40.0, 2, 0.8),
                new CarrelloDto(2, 90.0, 5, 2.1)
        );

        when(carrelloService.findCarrelliAttivi()).thenReturn(lista);

        mockMvc.perform(get("/Carrello/findCarrelliAttivi"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(is(1)))
                .andExpect(jsonPath("$[0].prezzoTotale").value(closeTo(40.0, 0.001)))
                .andExpect(jsonPath("$[0].quantita").value(is(2)))
                .andExpect(jsonPath("$[0].peso").value(closeTo(0.8, 0.001)))
                .andExpect(jsonPath("$[1].id").value(is(2)))
                .andExpect(jsonPath("$[1].prezzoTotale").value(closeTo(90.0, 0.001)))
                .andExpect(jsonPath("$[1].quantita").value(is(5)))
                .andExpect(jsonPath("$[1].peso").value(closeTo(2.1, 0.001)));
    }

    @Test
    void testFindByPrezzoTotaleGreaterThan() throws Exception {
        List<CarrelloDto> lista = List.of(
                new CarrelloDto(3, 120.0, 6, 3.0)
        );

        when(carrelloService.findByPrezzoTotaleGreaterThan(100.0))
                .thenReturn(lista);

        mockMvc.perform(get("/Carrello/findByPrezzoTotaleGreaterThan")
                        .param("prezzoTotale", "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(is(3)))
                .andExpect(jsonPath("$[0].prezzoTotale").value(closeTo(120.0, 0.001)))
                .andExpect(jsonPath("$[0].quantita").value(is(6)))
                .andExpect(jsonPath("$[0].peso").value(closeTo(3.0, 0.001)));
    }

    @Test
    void testFindByQuantitaGreaterThan() throws Exception {
        List<CarrelloDto> lista = List.of(
                new CarrelloDto(4, 80.0, 7, 1.9)
        );

        when(carrelloService.findByQuantitaGreaterThan(5))
                .thenReturn(lista);

        mockMvc.perform(get("/Carrello/findByQuantitaGreaterThan")
                        .param("quantita", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(is(4)))
                .andExpect(jsonPath("$[0].prezzoTotale").value(closeTo(80.0, 0.001)))
                .andExpect(jsonPath("$[0].quantita").value(is(7)))
                .andExpect(jsonPath("$[0].peso").value(closeTo(1.9, 0.001)));
    }

    @Test
    void testFindByPesoLessThan() throws Exception {
        List<CarrelloDto> lista = List.of(
                new CarrelloDto(5, 30.0, 1, 0.5)
        );

        when(carrelloService.findByPesoLessThan(1.0))
                .thenReturn(lista);

        mockMvc.perform(get("/Carrello/findByPesoLessThan")
                        .param("peso", "1.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(is(5)))
                .andExpect(jsonPath("$[0].prezzoTotale").value(closeTo(30.0, 0.001)))
                .andExpect(jsonPath("$[0].quantita").value(is(1)))
                .andExpect(jsonPath("$[0].peso").value(closeTo(0.5, 0.001)));
    }
}
