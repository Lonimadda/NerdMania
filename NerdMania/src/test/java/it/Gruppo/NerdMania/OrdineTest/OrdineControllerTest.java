package it.Gruppo.NerdMania.OrdineTest;

import it.Gruppo.NerdMania.Controller.OrdineController;
import it.Gruppo.NerdMania.DTO.OrdineDto;
import it.Gruppo.NerdMania.Modelli.Prodotto;
import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Service.OrdineService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrdineControllerTest {

    @Mock
    private OrdineService service;

    @InjectMocks
    private OrdineController controller;

    @Test
    void findByUserUsername_found() {
        User user = new User();
        user.setUsername("adinolfi");

        OrdineDto dto = new OrdineDto();
        dto.setUser(user);

        when(service.findByUserUsername("adinolfi")).thenReturn(List.of(dto));

        List<OrdineDto> result = controller.findByUserUsername("adinolfi");

        assertNotNull(result);
        assertEquals("adinolfi", result.getFirst().getUser().getUsername());

        verify(service).findByUserUsername("adinolfi");
    }

    @Test
    void findAllByOrderByCostoTotaleDesc_found() {
        OrdineDto dto = new OrdineDto();
        dto.setCostoTotale(100);
        OrdineDto dto1 = new OrdineDto();
        dto1.setCostoTotale(50);

        when(service.findAllByOrderByCostoTotaleDesc())
                .thenReturn(List.of(dto, dto1));

        List<OrdineDto> result = controller.findAllByOrderByCostoTotaleDesc();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(100, result.get(0).getCostoTotale());

        verify(service).findAllByOrderByCostoTotaleDesc();
    }

    @Test
    void findAllByOrderByCostoTotaleAsc_found() {
        OrdineDto dto = new OrdineDto();
        dto.setCostoTotale(10);
        OrdineDto dto1 = new OrdineDto();
        dto1.setCostoTotale(100);

        when(service.findAllByOrderByCostoTotaleAsc())
                .thenReturn(List.of(dto, dto1));

        List<OrdineDto> result = controller.findAllByOrderByCostoTotaleAsc();

        assertNotNull(result);
        assertEquals(10, result.get(0).getCostoTotale());

        verify(service).findAllByOrderByCostoTotaleAsc();
    }

    @Test
    void findByIndirizzoSpedizioneContainingIgnoreCase_found() {
        OrdineDto dto = new OrdineDto();
        dto.setIndirizzoSpedizione("via manzoni");

        when(service.findByIndirizzoSpedizioneContainingIgnoreCase("via manzoni"))
                .thenReturn(List.of(dto));

        List<OrdineDto> result =
                controller.findByIndirizzoSpedizioneContainingIgnoreCase("via manzoni");

        assertNotNull(result);
        assertEquals("via manzoni", result.getFirst().getIndirizzoSpedizione());

        verify(service).findByIndirizzoSpedizioneContainingIgnoreCase("via manzoni");
    }

    @Test
    void findByCostoTotaleGreaterThan_found() {
        OrdineDto dto = new OrdineDto();
        dto.setCostoTotale(120);

        when(service.findByCostoTotaleGreaterThan(110))
                .thenReturn(List.of(dto));

        List<OrdineDto> result = controller.findByCostoTotaleGreaterThan(110);

        assertNotNull(result);
        assertEquals(120, result.getFirst().getCostoTotale());

        verify(service).findByCostoTotaleGreaterThan(110);
    }

    @Test
    void findByCostoTotaleLessThan_found() {
        OrdineDto dto = new OrdineDto();
        dto.setCostoTotale(100);

        when(service.findByCostoTotaleLessThan(110))
                .thenReturn(List.of(dto));

        List<OrdineDto> result = controller.findByCostoTotaleLessThan(110);

        assertNotNull(result);
        assertEquals(100, result.getFirst().getCostoTotale());

        verify(service).findByCostoTotaleLessThan(110);
    }

    @Test
    void findByProdottiId_found() {
        Prodotto p1 = new Prodotto();
        p1.setId(1);
        Prodotto p2 = new Prodotto();
        p2.setId(2);

        List<Prodotto> prodotti = new ArrayList<>();
        prodotti.add(p1);
        prodotti.add(p2);

        OrdineDto dto = new OrdineDto();
        dto.setProdotti(prodotti);

        when(service.findByProdottiId(1)).thenReturn(List.of(dto));

        List<OrdineDto> result = controller.findByProdottiId(1);

        assertNotNull(result);
        assertEquals(1, result.getFirst().getProdotti().get(0).getId());
        assertEquals(2, result.getFirst().getProdotti().get(1).getId());

        verify(service).findByProdottiId(1);
    }
}