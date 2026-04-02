package it.Gruppo.NerdMania.ProdottoTest;

import it.Gruppo.NerdMania.DTO.ProdottoDto;
import it.Gruppo.NerdMania.Mapper.ProdottoMapper;
import it.Gruppo.NerdMania.Modelli.Prodotto;
import it.Gruppo.NerdMania.Repository.ProdottoRepository;
import it.Gruppo.NerdMania.Service.ProdottoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdottoServiceTest {

    @Mock
    private ProdottoRepository prodottoRepository;

    @Mock
    private ProdottoMapper prodottoMapper;

    @InjectMocks
    private ProdottoService prodottoService;

    // ---------------- search ----------------

    @Test
    void search_found() {
        Prodotto prodotto = new Prodotto();
        ProdottoDto dto = new ProdottoDto();
        List<Prodotto> list = List.of(prodotto);
        List<ProdottoDto> listDto = List.of(dto);

        when(prodottoRepository.search("mouse")).thenReturn(list);
        when(prodottoMapper.toDTOList(list)).thenReturn(listDto);

        List<ProdottoDto> result = prodottoService.search("mouse");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(prodottoRepository).search("mouse");
        verify(prodottoMapper).toDTOList(list);
    }

    @Test
    void search_empty() {
        List<Prodotto> list = List.of();
        List<ProdottoDto> listDto = List.of();

        when(prodottoRepository.search("mouse")).thenReturn(list);
        when(prodottoMapper.toDTOList(list)).thenReturn(listDto);

        List<ProdottoDto> result = prodottoService.search("mouse");

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(prodottoRepository).search("mouse");
        verify(prodottoMapper).toDTOList(list);
    }

    @Test
    void findProdottiEconomici_found() {
        Prodotto p = new Prodotto();
        ProdottoDto dto = new ProdottoDto();
        List<Prodotto> list = List.of(p);
        List<ProdottoDto> listDto = List.of(dto);

        when(prodottoRepository.findProdottiEconomici(50.0)).thenReturn(list);
        when(prodottoMapper.toDTOList(list)).thenReturn(listDto);

        List<ProdottoDto> result = prodottoService.findProdottiEconomici(50.0);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(prodottoRepository).findProdottiEconomici(50.0);
        verify(prodottoMapper).toDTOList(list);
    }

    @Test
    void findProdottiEconomici_empty() {
        List<Prodotto> list = List.of();
        List<ProdottoDto> listDto = List.of();

        when(prodottoRepository.findProdottiEconomici(50.0)).thenReturn(list);
        when(prodottoMapper.toDTOList(list)).thenReturn(listDto);

        List<ProdottoDto> result = prodottoService.findProdottiEconomici(50.0);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(prodottoRepository).findProdottiEconomici(50.0);
        verify(prodottoMapper).toDTOList(list);
    }

    // ---------------- findProdottiCostosi ----------------

    @Test
    void findProdottiCostosi_found() {
        Prodotto p = new Prodotto();
        ProdottoDto dto = new ProdottoDto();
        List<Prodotto> list = List.of(p);
        List<ProdottoDto> listDto = List.of(dto);

        when(prodottoRepository.findProdottiCostosi(500.0)).thenReturn(list);
        when(prodottoMapper.toDTOList(list)).thenReturn(listDto);

        List<ProdottoDto> result = prodottoService.findProdottiCostosi(500.0);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(prodottoRepository).findProdottiCostosi(500.0);
        verify(prodottoMapper).toDTOList(list);
    }

    @Test
    void findProdottiCostosi_empty() {
        List<Prodotto> list = List.of();
        List<ProdottoDto> listDto = List.of();

        when(prodottoRepository.findProdottiCostosi(500.0)).thenReturn(list);
        when(prodottoMapper.toDTOList(list)).thenReturn(listDto);

        List<ProdottoDto> result = prodottoService.findProdottiCostosi(500.0);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(prodottoRepository).findProdottiCostosi(500.0);
        verify(prodottoMapper).toDTOList(list);
    }

    @Test
    void findByPesoRange_found() {
        Prodotto p = new Prodotto();
        ProdottoDto dto = new ProdottoDto();
        List<Prodotto> list = List.of(p);
        List<ProdottoDto> listDto = List.of(dto);

        when(prodottoRepository.findByPesoRange(1f, 5f)).thenReturn(list);
        when(prodottoMapper.toDTOList(list)).thenReturn(listDto);

        List<ProdottoDto> result = prodottoService.findByPesoRange(1f, 5f);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(prodottoRepository).findByPesoRange(1f, 5f);
        verify(prodottoMapper).toDTOList(list);
    }

    @Test
    void findByPesoRange_empty() {
        List<Prodotto> list = List.of();
        List<ProdottoDto> listDto = List.of();

        when(prodottoRepository.findByPesoRange(1f, 5f)).thenReturn(list);
        when(prodottoMapper.toDTOList(list)).thenReturn(listDto);

        List<ProdottoDto> result = prodottoService.findByPesoRange(1f, 5f);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(prodottoRepository).findByPesoRange(1f, 5f);
        verify(prodottoMapper).toDTOList(list);
    }

    @Test
    void findAllOrderByNome_found() {
        Prodotto p = new Prodotto();
        ProdottoDto dto = new ProdottoDto();
        List<Prodotto> list = List.of(p);
        List<ProdottoDto> listDto = List.of(dto);

        when(prodottoRepository.findAllOrderByNome()).thenReturn(list);
        when(prodottoMapper.toDTOList(list)).thenReturn(listDto);

        List<ProdottoDto> result = prodottoService.findAllOrderByNome();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(prodottoRepository).findAllOrderByNome();
        verify(prodottoMapper).toDTOList(list);
    }

    @Test
    void findAllOrderByNome_empty() {
        List<Prodotto> list = List.of();
        List<ProdottoDto> listDto = List.of();

        when(prodottoRepository.findAllOrderByNome()).thenReturn(list);
        when(prodottoMapper.toDTOList(list)).thenReturn(listDto);

        List<ProdottoDto> result = prodottoService.findAllOrderByNome();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(prodottoRepository).findAllOrderByNome();
        verify(prodottoMapper).toDTOList(list);
    }

    @Test
    void findByCategoriaId_found() {
        Prodotto p = new Prodotto();
        ProdottoDto dto = new ProdottoDto();
        List<Prodotto> list = List.of(p);
        List<ProdottoDto> listDto = List.of(dto);

        when(prodottoRepository.findByCategoria_Id(1L)).thenReturn(list);
        when(prodottoMapper.toDTOList(list)).thenReturn(listDto);

        List<ProdottoDto> result = prodottoService.findByCategoriaId(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(prodottoRepository).findByCategoria_Id(1L);
        verify(prodottoMapper).toDTOList(list);
    }

    @Test
    void findByCategoriaId_empty() {
        List<Prodotto> list = List.of();
        List<ProdottoDto> listDto = List.of();

        when(prodottoRepository.findByCategoria_Id(1L)).thenReturn(list);
        when(prodottoMapper.toDTOList(list)).thenReturn(listDto);

        List<ProdottoDto> result = prodottoService.findByCategoriaId(1L);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(prodottoRepository).findByCategoria_Id(1L);
        verify(prodottoMapper).toDTOList(list);
    }
}

