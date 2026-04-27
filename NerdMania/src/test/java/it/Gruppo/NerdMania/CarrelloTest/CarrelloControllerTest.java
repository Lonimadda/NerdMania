package it.Gruppo.NerdMania.CarrelloTest;

import it.Gruppo.NerdMania.Controller.CarrelloController;
import it.Gruppo.NerdMania.DTO.CarrelloDto;
import it.Gruppo.NerdMania.Service.CarrelloService;
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
class CarrelloControllerTest {

    @Mock
    private CarrelloService carrelloService;

    @InjectMocks
    private CarrelloController controller;

    @Test
    void findByUser_found() {
        CarrelloDto dto = new CarrelloDto(1, 1, 50.0, 3, 1.2);

        when(carrelloService.findByUser(1)).thenReturn(dto);

        CarrelloDto result = controller.findByUser(1).getBody();

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals(50.0, result.getPrezzoTotale());
        assertEquals(3, result.getQuantita());
        assertEquals(1.2, result.getPeso());

        verify(carrelloService).findByUser(1);
    }

    @Test
    void findCarrelliAttivi_found() {
        List<CarrelloDto> lista = List.of(
                new CarrelloDto(1, 1, 40.0, 2, 0.8),
                new CarrelloDto(2, 1, 90.0, 5, 2.1)
        );

        when(carrelloService.findCarrelliAttivi()).thenReturn(lista);

        List<CarrelloDto> result = controller.findCarrelliAttivi();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(40.0, result.get(0).getPrezzoTotale());
        assertEquals(90.0, result.get(1).getPrezzoTotale());

        verify(carrelloService).findCarrelliAttivi();
    }

    @Test
    void findByPrezzoTotaleGreaterThan_found() {
        List<CarrelloDto> lista = List.of(
                new CarrelloDto(3, 1, 120.0, 6, 3.0)
        );

        when(carrelloService.findByPrezzoTotaleGreaterThan(100.0)).thenReturn(lista);

        List<CarrelloDto> result = controller.findByPrezzoTotaleGreaterThan(100.0);

        assertNotNull(result);
        assertEquals(120.0, result.getFirst().getPrezzoTotale());

        verify(carrelloService).findByPrezzoTotaleGreaterThan(100.0);
    }

    @Test
    void findByQuantitaGreaterThan_found() {
        List<CarrelloDto> lista = List.of(
                new CarrelloDto(4, 1, 80.0, 7, 1.9)
        );

        when(carrelloService.findByQuantitaGreaterThan(5)).thenReturn(lista);

        List<CarrelloDto> result = controller.findByQuantitaGreaterThan(5);

        assertNotNull(result);
        assertEquals(7, result.getFirst().getQuantita());

        verify(carrelloService).findByQuantitaGreaterThan(5);
    }

    @Test
    void findByPesoLessThan_found() {
        List<CarrelloDto> lista = List.of(
                new CarrelloDto(5, 1, 30.0, 1, 0.5)
        );

        when(carrelloService.findByPesoLessThan(1.0)).thenReturn(lista);

        List<CarrelloDto> result = controller.findByPesoLessThan(1.0);

        assertNotNull(result);
        assertEquals(0.5, result.getFirst().getPeso());

        verify(carrelloService).findByPesoLessThan(1.0);
    }
}