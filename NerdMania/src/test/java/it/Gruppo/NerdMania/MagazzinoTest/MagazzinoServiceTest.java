package it.Gruppo.NerdMania.MagazzinoTest;

import it.Gruppo.NerdMania.DTO.MagazzinoDto;
import it.Gruppo.NerdMania.Mapper.MagazzinoMapper;
import it.Gruppo.NerdMania.Modelli.Magazzino;
import it.Gruppo.NerdMania.Repository.MagazzinoRepository;
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
class MagazzinoServiceTest {

    @Mock
    private MagazzinoRepository magazzinoRepository;

    @Mock
    private MagazzinoMapper magazzinoMapper;

    @InjectMocks
    private MagazzinoService magazzinoService;

    // ---------------- search ----------------

    @Test
    void search_found() {
        Magazzino magazzino = new Magazzino();
        MagazzinoDto dto = new MagazzinoDto();

        List<Magazzino> list = List.of(magazzino);
        List<MagazzinoDto> listDto = List.of(dto);

        when(magazzinoRepository.search("pc")).thenReturn(list);
        when(magazzinoMapper.toDTOList(list)).thenReturn(listDto);

        List<MagazzinoDto> result = magazzinoService.search("pc");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(magazzinoRepository).search("pc");
        verify(magazzinoMapper).toDTOList(list);
    }

    @Test
    void search_empty() {
        List<Magazzino> list = List.of();
        List<MagazzinoDto> listDto = List.of();

        when(magazzinoRepository.search("pc")).thenReturn(list);
        when(magazzinoMapper.toDTOList(list)).thenReturn(listDto);

        List<MagazzinoDto> result = magazzinoService.search("pc");

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(magazzinoRepository).search("pc");
        verify(magazzinoMapper).toDTOList(list);
    }

    @Test
    void search_null() {
        when(magazzinoRepository.search(null)).thenReturn(null);

        List<MagazzinoDto> result = magazzinoService.search(null);

        assertNull(result);
        verify(magazzinoRepository).search(null);
    }

    // ---------------- findMagazziniConScorteBasse ----------------

    @Test
    void findMagazziniConScorteBasse_found() {
        Magazzino m = new Magazzino();
        MagazzinoDto dto = new MagazzinoDto();
        List<Magazzino> list = List.of(m);
        List<MagazzinoDto> listDto = List.of(dto);

        when(magazzinoRepository.findMagazziniConScorteBasse(10)).thenReturn(list);
        when(magazzinoMapper.toDTOList(list)).thenReturn(listDto);

        List<MagazzinoDto> result = magazzinoService.findMagazziniConScorteBasse(10);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(magazzinoRepository).findMagazziniConScorteBasse(10);
        verify(magazzinoMapper).toDTOList(list);
    }

    @Test
    void findMagazziniConScorteBasse_empty() {
        List<Magazzino> list = List.of();
        List<MagazzinoDto> listDto = List.of();

        when(magazzinoRepository.findMagazziniConScorteBasse(10)).thenReturn(list);
        when(magazzinoMapper.toDTOList(list)).thenReturn(listDto);

        List<MagazzinoDto> result = magazzinoService.findMagazziniConScorteBasse(10);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(magazzinoRepository).findMagazziniConScorteBasse(10);
        verify(magazzinoMapper).toDTOList(list);
    }

    @Test
    void findMagazziniConScorteBasse_null() {
        when(magazzinoRepository.findMagazziniConScorteBasse(10)).thenReturn(null);

        List<MagazzinoDto> result = magazzinoService.findMagazziniConScorteBasse(10);

        assertNull(result);
        verify(magazzinoRepository).findMagazziniConScorteBasse(10);
    }

    // ---------------- findByCodice ----------------

    @Test
    void findByCodice_found() {
        Magazzino m = new Magazzino();
        MagazzinoDto dto = new MagazzinoDto();

        when(magazzinoRepository.findByCodice("A123")).thenReturn(m);
        when(magazzinoMapper.toDTO(m)).thenReturn(dto);

        MagazzinoDto result = magazzinoService.findByCodice("A123");

        assertNotNull(result);
        verify(magazzinoRepository).findByCodice("A123");
        verify(magazzinoMapper).toDTO(m);
    }

    @Test
    void findByCodice_null() {
        when(magazzinoRepository.findByCodice("A123")).thenReturn(null);

        MagazzinoDto result = magazzinoService.findByCodice("A123");

        assertNull(result);
        verify(magazzinoRepository).findByCodice("A123");
    }

    // ---------------- findMagazziniByProdottoId ----------------

    @Test
    void findMagazziniByProdottoId_found() {
        Magazzino m = new Magazzino();
        MagazzinoDto dto = new MagazzinoDto();
        List<Magazzino> list = List.of(m);
        List<MagazzinoDto> listDto = List.of(dto);

        when(magazzinoRepository.findMagazziniByProdottoId(1L)).thenReturn(list);
        when(magazzinoMapper.toDTOList(list)).thenReturn(listDto);

        List<MagazzinoDto> result = magazzinoService.findMagazziniByProdottoId(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(magazzinoRepository).findMagazziniByProdottoId(1L);
        verify(magazzinoMapper).toDTOList(list);
    }

    @Test
    void findMagazziniByProdottoId_empty() {
        List<Magazzino> list = List.of();
        List<MagazzinoDto> listDto = List.of();

        when(magazzinoRepository.findMagazziniByProdottoId(1L)).thenReturn(list);
        when(magazzinoMapper.toDTOList(list)).thenReturn(listDto);

        List<MagazzinoDto> result = magazzinoService.findMagazziniByProdottoId(1L);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(magazzinoRepository).findMagazziniByProdottoId(1L);
        verify(magazzinoMapper).toDTOList(list);
    }

    @Test
    void findMagazziniByProdottoId_null() {
        when(magazzinoRepository.findMagazziniByProdottoId(null)).thenReturn(null);

        List<MagazzinoDto> result = magazzinoService.findMagazziniByProdottoId(null);

        assertNull(result);
        verify(magazzinoRepository).findMagazziniByProdottoId(null);
    }

    // ---------------- findMagazziniByNomeProdotto ----------------

    @Test
    void findMagazziniByNomeProdotto_found() {
        Magazzino m = new Magazzino();
        MagazzinoDto dto = new MagazzinoDto();
        List<Magazzino> list = List.of(m);
        List<MagazzinoDto> listDto = List.of(dto);

        when(magazzinoRepository.findMagazziniByNomeProdotto("Mouse")).thenReturn(list);
        when(magazzinoMapper.toDTOList(list)).thenReturn(listDto);

        List<MagazzinoDto> result = magazzinoService.findMagazziniByNomeProdotto("Mouse");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(magazzinoRepository).findMagazziniByNomeProdotto("Mouse");
        verify(magazzinoMapper).toDTOList(list);
    }

    @Test
    void findMagazziniByNomeProdotto_empty() {
        List<Magazzino> list = List.of();
        List<MagazzinoDto> listDto = List.of();

        when(magazzinoRepository.findMagazziniByNomeProdotto("Mouse")).thenReturn(list);
        when(magazzinoMapper.toDTOList(list)).thenReturn(listDto);

        List<MagazzinoDto> result = magazzinoService.findMagazziniByNomeProdotto("Mouse");

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(magazzinoRepository).findMagazziniByNomeProdotto("Mouse");
        verify(magazzinoMapper).toDTOList(list);
    }

    @Test
    void findMagazziniByNomeProdotto_null() {
        when(magazzinoRepository.findMagazziniByNomeProdotto(null)).thenReturn(null);

        List<MagazzinoDto> result = magazzinoService.findMagazziniByNomeProdotto(null);

        assertNull(result);
        verify(magazzinoRepository).findMagazziniByNomeProdotto(null);
    }
}
