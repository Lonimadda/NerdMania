package it.Gruppo.NerdMania.SpedizioneTest;

import it.Gruppo.NerdMania.Controller.SpedizioneController;
import it.Gruppo.NerdMania.DTO.SpedizioneDto;
import it.Gruppo.NerdMania.Modelli.Ordine;
import it.Gruppo.NerdMania.Service.SpedizioneService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SpedizioneControllerTest {

    @Mock
    private SpedizioneService service;

    @InjectMocks
    private SpedizioneController controller;



    // ------------------------------------------------

    @Test
    void findByPesoGreaterThan_found() {

        SpedizioneDto dto = new SpedizioneDto();
        dto.setPeso(15);

        when(service.findByPesoGreaterThan(10))
                .thenReturn(List.of(dto));

        List<SpedizioneDto> result =
                controller.findByPesoGreaterThan(10);

        assertNotNull(result);
        assertEquals(15, result.getFirst().getPeso());

        verify(service).findByPesoGreaterThan(10);
    }

    // ------------------------------------------------

    @Test
    void findByPesoGreaterThan_empty() {

        when(service.findByPesoGreaterThan(10))
                .thenReturn(List.of());

        List<SpedizioneDto> result =
                controller.findByPesoGreaterThan(10);

        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(service).findByPesoGreaterThan(10);
    }

    // ------------------------------------------------

    @Test
    void findByPesoLessThan_found() {

        SpedizioneDto dto = new SpedizioneDto();
        dto.setPeso(9);

        when(service.findByPesoLessThan(10))
                .thenReturn(List.of(dto));

        List<SpedizioneDto> result =
                controller.findByPesoLessThan(10);

        assertNotNull(result);
        assertEquals(9, result.getFirst().getPeso());

        verify(service).findByPesoLessThan(10);
    }

    // ------------------------------------------------

    @Test
    void findByAltezzaBetween_found() {

        SpedizioneDto dto = new SpedizioneDto();
        dto.setAltezza(12);

        when(service.findByAltezzaBetween(10, 15))
                .thenReturn(List.of(dto));

        List<SpedizioneDto> result =
                controller.findByAltezzaBetween(10, 15);

        assertNotNull(result);
        assertEquals(12, result.getFirst().getAltezza());

        verify(service).findByAltezzaBetween(10, 15);
    }

    // ------------------------------------------------

    @Test
    void findByOrdineId_found() {

        Ordine ordine = new Ordine();
        ordine.setId(1);

        SpedizioneDto dto = new SpedizioneDto();
        dto.setOrdine(ordine);

        when(service.findByOrdineId(1))
                .thenReturn(List.of(dto));

        List<SpedizioneDto> result =
                controller.findByOrdineId(1);

        assertNotNull(result);
        assertEquals(1,
                result.getFirst().getOrdine().getId());

        verify(service).findByOrdineId(1);
    }

    // ------------------------------------------------

    @Test
    void findByOrdineId_empty() {

        when(service.findByOrdineId(1))
                .thenReturn(List.of());

        List<SpedizioneDto> result =
                controller.findByOrdineId(1);

        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(service).findByOrdineId(1);
    }

    // ------------------------------------------------

    @Test
    void findByAltezzaGreaterThanOrLunghezzaGreaterThan_found() {

        SpedizioneDto dto = new SpedizioneDto();
        dto.setAltezza(10);
        dto.setLunghezza(15);

        when(service
                .findByAltezzaGreaterThanOrLunghezzaGreaterThan(15, 5))
                .thenReturn(List.of(dto));

        List<SpedizioneDto> result =
                controller
                        .findByAltezzaGreaterThanOrLunghezzaGreaterThan(15, 5);

        assertNotNull(result);
        assertEquals(10,
                result.getFirst().getAltezza());
        assertEquals(15,
                result.getFirst().getLunghezza());

        verify(service)
                .findByAltezzaGreaterThanOrLunghezzaGreaterThan(15, 5);
    }

    // ------------------------------------------------

    @Test
    void findByAltezzaGreaterThanOrLunghezzaGreaterThan_empty() {

        when(service
                .findByAltezzaGreaterThanOrLunghezzaGreaterThan(15, 5))
                .thenReturn(List.of());

        List<SpedizioneDto> result =
                controller
                        .findByAltezzaGreaterThanOrLunghezzaGreaterThan(15, 5);

        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(service)
                .findByAltezzaGreaterThanOrLunghezzaGreaterThan(15, 5);
    }

}