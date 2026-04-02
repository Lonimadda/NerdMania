package it.Gruppo.NerdMania.OrdineTest;

import it.Gruppo.NerdMania.Controller.OrdineController;
import it.Gruppo.NerdMania.DTO.OrdineDto;
import it.Gruppo.NerdMania.Modelli.Prodotto;
import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Service.OrdineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrdineController.class)
class OrdineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OrdineService service;

    @Test
    void shouldFindByUserUsername() throws Exception {
        User user= new User();
        user.setUsername("adinolfi");

        OrdineDto dto = new OrdineDto();
        dto.setUser(user);

        when(service.findByUserUsername("adinolfi")).thenReturn(List.of(dto));

        mockMvc.perform(get("/Ordine/findByUserUsername")
                        .param("username", "adinolfi"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].user.username").value("adinolfi"));
    }

    @Test
    void shouldFindAllByOrderByCostoTotaleDesc() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setCostoTotale(100);
        OrdineDto dto1 = new OrdineDto();
        dto1.setCostoTotale(50);
        OrdineDto dto2 = new OrdineDto();
        dto2.setCostoTotale(10);

        List<OrdineDto> dtos = List.of(dto, dto1, dto2);

        when(service.findAllByOrderByCostoTotaleDesc()).thenReturn(dtos);

        mockMvc.perform(get("/Ordine/findAllByOrderByCostoTotaleDesc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].costoTotale").value(100))
                .andExpect(jsonPath("$[1].costoTotale").value(50))
                .andExpect(jsonPath("$[2].costoTotale").value(10));
    }

    @Test
    void shouldFindAllByOrderByCostoTotaleAsc() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setCostoTotale(10);
        OrdineDto dto1 = new OrdineDto();
        dto1.setCostoTotale(50);
        OrdineDto dto2 = new OrdineDto();
        dto2.setCostoTotale(100);

        List<OrdineDto> dtos = List.of(dto, dto1, dto2);

        when(service.findAllByOrderByCostoTotaleAsc()).thenReturn(dtos);

        mockMvc.perform(get("/Ordine/findAllByOrderByCostoTotaleAsc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].costoTotale").value(10))
                .andExpect(jsonPath("$[1].costoTotale").value(50))
                .andExpect(jsonPath("$[2].costoTotale").value(100));
    }

    @Test
    void shouldFindByIndirizzoSpedizioneContainingIgnoreCase() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setIndirizzoSpedizione("via manzoni");

        when(service.findByIndirizzoSpedizioneContainingIgnoreCase("via manzoni")).thenReturn(List.of(dto));

        mockMvc.perform(get("/Ordine/findByIndirizzoSpedizioneContainingIgnoreCase")
                        .param("testo", "via manzoni"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].indirizzoSpedizione").value("via manzoni"));
    }

    @Test
    void shouldFindByCostoTotaleGreaterThan() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setCostoTotale(120);

        when(service.findByCostoTotaleGreaterThan(110)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Ordine/findByCostoTotaleGreaterThan")
                        .param("prezzo", "110"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].costoTotale").value(120));
    }

    @Test
    void shouldFindByCostoTotaleLessThan() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setCostoTotale(100);

        when(service.findByCostoTotaleLessThan(110)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Ordine/findByCostoTotaleLessThan")
                        .param("prezzo", "110"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].costoTotale").value(100));
    }

    @Test
    void shouldFindByProdottiId() throws Exception {
        Prodotto prodotto= new Prodotto();
        prodotto.setId(1);
        Prodotto prodotto1= new Prodotto();
        prodotto1.setId(2);
        List<Prodotto> prodotti= new ArrayList<>();
        prodotti.add(prodotto);
        prodotti.add(prodotto1);

        OrdineDto dto = new OrdineDto();
        dto.setProdotti(prodotti);

        when(service.findByProdottiId(1)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Ordine/findByProdottiId")
                        .param("prodottoId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].prodotti[0].id").value(1))
                .andExpect(jsonPath("$[0].prodotti[1].id").value(2));
    }
}
