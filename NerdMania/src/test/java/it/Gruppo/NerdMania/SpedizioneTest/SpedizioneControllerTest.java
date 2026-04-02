package it.Gruppo.NerdMania.SpedizioneTest;

import it.Gruppo.NerdMania.Controller.SpedizioneController;
import it.Gruppo.NerdMania.DTO.SpedizioneDto;
import it.Gruppo.NerdMania.Modelli.Ordine;
import it.Gruppo.NerdMania.Service.SpedizioneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SpedizioneController.class)
class SpedizioneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SpedizioneService service;

    @Test
    void shouldFindByFragileTrue() throws Exception {
        SpedizioneDto dto = new SpedizioneDto();
        dto.setFragile(true);

        when(service.findByFragileTrue()).thenReturn(List.of(dto));

        mockMvc.perform(get("/Spedizione/findByFragileTrue"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fragile").value(true));
    }

    @Test
    void shouldFindByEsteroTrue() throws Exception {
        SpedizioneDto dto = new SpedizioneDto();
        dto.setEstero(true);

        when(service.findByEsteroTrue()).thenReturn(List.of(dto));

        mockMvc.perform(get("/Spedizione/findByEsteroTrue"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].estero").value(true));
    }

    @Test
    void shouldFindByPesoGreaterThan() throws Exception {
        SpedizioneDto dto = new SpedizioneDto();
        dto.setPeso(15);

        when(service.findByPesoGreaterThan(10)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Spedizione/findByPesoGreaterThan")
                        .param("peso", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].peso").value(15));
    }

    @Test
    void shouldFindByPesoLessThan() throws Exception {
        SpedizioneDto dto = new SpedizioneDto();
        dto.setPeso(9);

        when(service.findByPesoLessThan(10)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Spedizione/findByPesoLessThan")
                        .param("peso", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].peso").value(9));
    }

    @Test
    void shouldFindByAltezzaBetween() throws Exception {
        SpedizioneDto dto = new SpedizioneDto();
        dto.setAltezza(12);

        when(service.findByAltezzaBetween(10,15)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Spedizione/findByAltezzaBetween")
                        .param("min", "10")
                        .param("max","15"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].altezza").value(12));
    }

    @Test
    void shouldFindByOrdineId() throws Exception {
        Ordine ordine= new Ordine();
        ordine.setId(1);

        SpedizioneDto dto = new SpedizioneDto();
        dto.setOrdine(ordine);

        when(service.findByOrdineId(1)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Spedizione/findByOrdineId")
                        .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].ordine.id").value(1));
    }

    @Test
    void shouldFindByAltezzaGreaterThanOrLunghezzaGreaterThan() throws Exception {
        SpedizioneDto dto = new SpedizioneDto();
        dto.setAltezza(10);
        dto.setLunghezza(15);

        when(service.findByAltezzaGreaterThanOrLunghezzaGreaterThan(15,5)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Spedizione/findByAltezzaGreaterThanOrLunghezzaGreaterThan")
                        .param("h", "15")
                        .param("l","5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].altezza").value(10))
                .andExpect(jsonPath("$[0].lunghezza").value(15));
    }
}