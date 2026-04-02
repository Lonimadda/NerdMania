package it.Gruppo.NerdMania.ProdottoTest;

import it.Gruppo.NerdMania.Controller.ProdottoController;
import it.Gruppo.NerdMania.DTO.ProdottoDto;
import it.Gruppo.NerdMania.Service.ProdottoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdottoControllerTest {

    @Mock
    private ProdottoService service;

    @InjectMocks
    private ProdottoController controller;

    // ---------------- filtri ----------------
    @Test
    void filtri_found() {
        Pageable pageable = PageRequest.of(0, 10);
        ProdottoDto dto = new ProdottoDto();
        Page<ProdottoDto> page = new PageImpl<>(List.of(dto));
        when(service.getProdottiFiltrati("pc", 10.0, 100.0, 1, pageable)).thenReturn(page);
        Page<ProdottoDto> result = controller.filtri("pc", 10.0, 100.0, 1, pageable);
        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        verify(service).getProdottiFiltrati("pc", 10.0, 100.0, 1, pageable);
    }

    @Test
    void filtri_empty() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<ProdottoDto> page = new PageImpl<>(List.of());
        when(service.getProdottiFiltrati("pc", null, null, null, pageable)).thenReturn(page);
        Page<ProdottoDto> result = controller.filtri("pc", null, null, null, pageable);
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(service).getProdottiFiltrati("pc", null, null, null, pageable);
    }

    @Test
    void filtri_null() {
        Pageable pageable = PageRequest.of(0, 10);
        when(service.getProdottiFiltrati(null, null, null, null, pageable)).thenReturn(null);
        Page<ProdottoDto> result = controller.filtri(null, null, null, null, pageable);
        assertNull(result);
        verify(service).getProdottiFiltrati(null, null, null, null, pageable);
    }

    // ---------------- paginati ----------------
    @Test
    void getProdotto_found() {
        Pageable pageable = PageRequest.of(0, 10);
        ProdottoDto dto = new ProdottoDto();
        Page<ProdottoDto> page = new PageImpl<>(List.of(dto));
        when(service.getProdottiPaginati(pageable)).thenReturn(page);
        Page<ProdottoDto> result = controller.getProdotto(pageable);
        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        verify(service).getProdottiPaginati(pageable);
    }

    @Test
    void getProdotto_empty() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<ProdottoDto> page = new PageImpl<>(List.of());
        when(service.getProdottiPaginati(pageable)).thenReturn(page);
        Page<ProdottoDto> result = controller.getProdotto(pageable);
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(service).getProdottiPaginati(pageable);
    }

    @Test
    void getProdotto_null() {
        Pageable pageable = PageRequest.of(0, 10);
        when(service.getProdottiPaginati(pageable)).thenReturn(null);
        Page<ProdottoDto> result = controller.getProdotto(pageable);
        assertNull(result);
        verify(service).getProdottiPaginati(pageable);
    }

    // ---------------- search ----------------
    @Test
    void search_found() {
        ProdottoDto dto = new ProdottoDto();
        List<ProdottoDto> list = List.of(dto);
        when(service.search("pc")).thenReturn(list);
        List<ProdottoDto> result = controller.search("pc");
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(service).search("pc");
    }

    @Test
    void search_empty() {
        when(service.search("pc")).thenReturn(List.of());
        List<ProdottoDto> result = controller.search("pc");
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(service).search("pc");
    }

    @Test
    void search_null() {
        when(service.search(null)).thenReturn(null);
        List<ProdottoDto> result = controller.search(null);
        assertNull(result);
        verify(service).search(null);
    }

    // ---------------- findProdottiEconomici ----------------
    @Test
    void findProdottiEconomici_found() {
        ProdottoDto dto = new ProdottoDto();
        List<ProdottoDto> list = List.of(dto);
        when(service.findProdottiEconomici(50.0)).thenReturn(list);
        List<ProdottoDto> result = controller.findProdottiEconomici(50.0);
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(service).findProdottiEconomici(50.0);
    }

    @Test
    void findProdottiEconomici_empty() {
        when(service.findProdottiEconomici(50.0)).thenReturn(List.of());
        List<ProdottoDto> result = controller.findProdottiEconomici(50.0);
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(service).findProdottiEconomici(50.0);
    }

    @Test
    void findProdottiEconomici_null() {
        when(service.findProdottiEconomici(null)).thenReturn(null);
        List<ProdottoDto> result = controller.findProdottiEconomici(null);
        assertNull(result);
        verify(service).findProdottiEconomici(null);
    }

    // ---------------- findProdottiCostosi ----------------
    @Test
    void findProdottiCostosi_found() {
        ProdottoDto dto = new ProdottoDto();
        List<ProdottoDto> list = List.of(dto);
        when(service.findProdottiCostosi(100.0)).thenReturn(list);
        List<ProdottoDto> result = controller.findProdottiCostosi(100.0);
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(service).findProdottiCostosi(100.0);
    }

    @Test
    void findProdottiCostosi_empty() {
        when(service.findProdottiCostosi(100.0)).thenReturn(List.of());
        List<ProdottoDto> result = controller.findProdottiCostosi(100.0);
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(service).findProdottiCostosi(100.0);
    }

    @Test
    void findProdottiCostosi_null() {
        when(service.findProdottiCostosi(null)).thenReturn(null);
        List<ProdottoDto> result = controller.findProdottiCostosi(null);
        assertNull(result);
        verify(service).findProdottiCostosi(null);
    }

    // ---------------- findByPesoRange ----------------
    @Test
    void findByPesoRange_found() {
        ProdottoDto dto = new ProdottoDto();
        List<ProdottoDto> list = List.of(dto);
        when(service.findByPesoRange(1.0f, 5.0f)).thenReturn(list);
        List<ProdottoDto> result = controller.findByPesoRange(1.0f, 5.0f);
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(service).findByPesoRange(1.0f, 5.0f);
    }

    @Test
    void findByPesoRange_empty() {
        when(service.findByPesoRange(1.0f, 5.0f)).thenReturn(List.of());
        List<ProdottoDto> result = controller.findByPesoRange(1.0f, 5.0f);
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(service).findByPesoRange(1.0f, 5.0f);
    }

    @Test
    void findByPesoRange_null() {
        when(service.findByPesoRange(1.0f, 5.0f)).thenReturn(null);
        List<ProdottoDto> result = controller.findByPesoRange(1.0f, 5.0f);
        assertNull(result);
        verify(service).findByPesoRange(1.0f, 5.0f);
    }

    // ---------------- findAllOrderByNome ----------------
    @Test
    void findAllOrderByNome_found() {
        ProdottoDto dto = new ProdottoDto();
        List<ProdottoDto> list = List.of(dto);
        when(service.findAllOrderByNome()).thenReturn(list);
        List<ProdottoDto> result = controller.findAllOrderByNome();
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(service).findAllOrderByNome();
    }

    @Test
    void findAllOrderByNome_empty() {
        when(service.findAllOrderByNome()).thenReturn(List.of());
        List<ProdottoDto> result = controller.findAllOrderByNome();
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(service).findAllOrderByNome();
    }

    @Test
    void findAllOrderByNome_null() {
        when(service.findAllOrderByNome()).thenReturn(null);
        List<ProdottoDto> result = controller.findAllOrderByNome();
        assertNull(result);
        verify(service).findAllOrderByNome();
    }

    // ---------------- findByCategoriaId ----------------
    @Test
    void findByCategoriaId_found() {
        ProdottoDto dto = new ProdottoDto();
        List<ProdottoDto> list = List.of(dto);
        when(service.findByCategoriaId(1L)).thenReturn(list);
        List<ProdottoDto> result = controller.findByCategoriaId(1L);
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(service).findByCategoriaId(1L);
    }

    @Test
    void findByCategoriaId_empty() {
        when(service.findByCategoriaId(1L)).thenReturn(List.of());
        List<ProdottoDto> result = controller.findByCategoriaId(1L);
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(service).findByCategoriaId(1L);
    }

    @Test
    void findByCategoriaId_null() {
        when(service.findByCategoriaId(null)).thenReturn(null);
        List<ProdottoDto> result = controller.findByCategoriaId(null);
        assertNull(result);
        verify(service).findByCategoriaId(null);
    }
}