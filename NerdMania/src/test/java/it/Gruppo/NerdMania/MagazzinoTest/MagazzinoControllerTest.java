package it.Gruppo.NerdMania.MagazzinoTest;

import it.Gruppo.NerdMania.Controller.MagazzinoController;
import it.Gruppo.NerdMania.DTO.MagazzinoDto;
import it.Gruppo.NerdMania.Service.MagazzinoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MagazzinoControllerTest {

    @Mock
    private MagazzinoService service;

    @InjectMocks
    private MagazzinoController controller;

    @Test
    void search_found() {
        MagazzinoDto dto = new MagazzinoDto();
        List<MagazzinoDto> list = List.of(dto);

        when(service.search("pc")).thenReturn(list);

        List<MagazzinoDto> result = controller.search("pc");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(service).search("pc");
    }

    @Test
    void search_empty() {
        when(service.search("pc")).thenReturn(List.of());

        List<MagazzinoDto> result = controller.search("pc");

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(service).search("pc");
    }

    @Test
    void search_null() {
        when(service.search(null)).thenReturn(null);

        List<MagazzinoDto> result = controller.search(null);

        assertNull(result);
        verify(service).search(null);
    }

    @Test
    void findMagazziniConScorteBasse_found() {
        MagazzinoDto dto = new MagazzinoDto();
        List<MagazzinoDto> list = List.of(dto);

        when(service.findMagazziniConScorteBasse(10)).thenReturn(list);

        List<MagazzinoDto> result = controller.findMagazziniConScorteBasse(10);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(service).findMagazziniConScorteBasse(10);
    }

    @Test
    void findMagazziniConScorteBasse_empty() {
        when(service.findMagazziniConScorteBasse(10)).thenReturn(List.of());

        List<MagazzinoDto> result = controller.findMagazziniConScorteBasse(10);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(service).findMagazziniConScorteBasse(10);
    }

    @Test
    void findMagazziniConScorteBasse_null() {
        when(service.findMagazziniConScorteBasse(10)).thenReturn(null);

        List<MagazzinoDto> result = controller.findMagazziniConScorteBasse(10);

        assertNull(result);
        verify(service).findMagazziniConScorteBasse(10);
    }

    @Test
    void findMagazziniConScorteAlte_found() {
        MagazzinoDto dto = new MagazzinoDto();
        List<MagazzinoDto> list = List.of(dto);

        when(service.findMagazziniConScorteAlte(100)).thenReturn(list);

        List<MagazzinoDto> result = controller.findMagazziniConScorteAlte(100);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(service).findMagazziniConScorteAlte(100);
    }

    @Test
    void findMagazziniConScorteAlte_empty() {
        when(service.findMagazziniConScorteAlte(100)).thenReturn(List.of());

        List<MagazzinoDto> result = controller.findMagazziniConScorteAlte(100);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(service).findMagazziniConScorteAlte(100);
    }

    @Test
    void findMagazziniConScorteAlte_null() {
        when(service.findMagazziniConScorteAlte(100)).thenReturn(null);

        List<MagazzinoDto> result = controller.findMagazziniConScorteAlte(100);

        assertNull(result);
        verify(service).findMagazziniConScorteAlte(100);
    }

    @Test
    void findByCodice_found() {
        MagazzinoDto dto = new MagazzinoDto();

        when(service.findByCodice("A123")).thenReturn(dto);

        MagazzinoDto result = controller.findByCodice("A123");

        assertNotNull(result);
        verify(service).findByCodice("A123");
    }

    @Test
    void findByCodice_empty() {
        when(service.findByCodice("A123")).thenReturn(null);

        MagazzinoDto result = controller.findByCodice("A123");

        assertNull(result);
        verify(service).findByCodice("A123");
    }

    @Test
    void findByCodice_null() {
        when(service.findByCodice(null)).thenReturn(null);

        MagazzinoDto result = controller.findByCodice(null);

        assertNull(result);
        verify(service).findByCodice(null);
    }

    @Test
    void findMagazziniByProdottoId_found() {
        MagazzinoDto dto = new MagazzinoDto();
        List<MagazzinoDto> list = List.of(dto);

        when(service.findMagazziniByProdottoId(1L)).thenReturn(list);

        List<MagazzinoDto> result = controller.findMagazziniByProdottoId(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(service).findMagazziniByProdottoId(1L);
    }

    @Test
    void findMagazziniByProdottoId_empty() {
        when(service.findMagazziniByProdottoId(1L)).thenReturn(List.of());

        List<MagazzinoDto> result = controller.findMagazziniByProdottoId(1L);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(service).findMagazziniByProdottoId(1L);
    }

    @Test
    void findMagazziniByProdottoId_null() {
        when(service.findMagazziniByProdottoId(null)).thenReturn(null);

        List<MagazzinoDto> result = controller.findMagazziniByProdottoId(null);

        assertNull(result);
        verify(service).findMagazziniByProdottoId(null);
    }

    @Test
    void findMagazziniByNomeProdotto_found() {
        MagazzinoDto dto = new MagazzinoDto();
        List<MagazzinoDto> list = List.of(dto);

        when(service.findMagazziniByNomeProdotto("Mouse")).thenReturn(list);

        List<MagazzinoDto> result = controller.findMagazziniByNomeProdotto("Mouse");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(service).findMagazziniByNomeProdotto("Mouse");
    }

    @Test
    void findMagazziniByNomeProdotto_empty() {
        when(service.findMagazziniByNomeProdotto("Mouse")).thenReturn(List.of());

        List<MagazzinoDto> result = controller.findMagazziniByNomeProdotto("Mouse");

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(service).findMagazziniByNomeProdotto("Mouse");
    }

    @Test
    void findMagazziniByNomeProdotto_null() {
        when(service.findMagazziniByNomeProdotto(null)).thenReturn(null);

        List<MagazzinoDto> result = controller.findMagazziniByNomeProdotto(null);

        assertNull(result);
        verify(service).findMagazziniByNomeProdotto(null);
    }
}
