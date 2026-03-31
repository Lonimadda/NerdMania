package it.Gruppo.NerdMania.CarrelloTest;

import it.Gruppo.NerdMania.DTO.CarrelloDto;
import it.Gruppo.NerdMania.Mapper.CarrelloMapper;
import it.Gruppo.NerdMania.Mapper.Converter;
import it.Gruppo.NerdMania.Modelli.Carrello;
import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Repository.CarrelloRepository;
import it.Gruppo.NerdMania.Service.CarrelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarrelloServiceTest {

    @Mock
    private CarrelloRepository carrelloRepository;

    @Mock
    private Converter<Carrello, CarrelloDto> converter;

    @Mock
    private CarrelloMapper carrelloMapper;

    private CarrelloService carrelloService;

    @BeforeEach
    void setUp() {
        carrelloService = new CarrelloService(carrelloRepository, converter, carrelloMapper, carrelloRepository);
    }

    @Test
    void testFindByUser() {
        User user = new User();
        user.setId(1);

        Carrello carrello = new Carrello();
        carrello.setId(1);

        CarrelloDto dto = new CarrelloDto(1, 50.0, 3, 1.2);

        when(carrelloRepository.findByUser(user)).thenReturn(Optional.of(carrello));
        when(carrelloMapper.toDTO(carrello)).thenReturn(dto);

        CarrelloDto result = carrelloService.findByUser(user);

        assertEquals(dto, result);
        verify(carrelloRepository).findByUser(user);
        verify(carrelloMapper).toDTO(carrello);
    }

    @Test
    void testFindByUserThrowsWhenNotFound() {
        User user = new User();
        user.setId(1);

        when(carrelloRepository.findByUser(user)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> carrelloService.findByUser(user));

        assertEquals("Carrello non trovato per l'utente", exception.getMessage());
        verify(carrelloRepository).findByUser(user);
    }

    @Test
    void testFindCarrelliAttivi() {
        Carrello carrello1 = new Carrello();
        carrello1.setId(1);
        Carrello carrello2 = new Carrello();
        carrello2.setId(2);

        CarrelloDto dto1 = new CarrelloDto(1, 40.0, 2, 0.8);
        CarrelloDto dto2 = new CarrelloDto(2, 90.0, 5, 2.1);

        when(carrelloRepository.findByOrdineIsNull()).thenReturn(List.of(carrello1, carrello2));
        when(carrelloMapper.toDTO(carrello1)).thenReturn(dto1);
        when(carrelloMapper.toDTO(carrello2)).thenReturn(dto2);

        List<CarrelloDto> result = carrelloService.findCarrelliAttivi();

        assertEquals(2, result.size());
        assertEquals(dto1, result.get(0));
        assertEquals(dto2, result.get(1));
        verify(carrelloRepository).findByOrdineIsNull();
        verify(carrelloMapper).toDTO(carrello1);
        verify(carrelloMapper).toDTO(carrello2);
    }

    @Test
    void testFindByPrezzoTotaleGreaterThan() {
        Carrello carrello = new Carrello();
        carrello.setId(3);

        CarrelloDto dto = new CarrelloDto(3, 120.0, 6, 3.0);

        when(carrelloRepository.findByPrezzoTotaleGreaterThan(100.0)).thenReturn(List.of(carrello));
        when(carrelloMapper.toDTO(carrello)).thenReturn(dto);

        List<CarrelloDto> result = carrelloService.findByPrezzoTotaleGreaterThan(100.0);

        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
        verify(carrelloRepository).findByPrezzoTotaleGreaterThan(100.0);
        verify(carrelloMapper).toDTO(carrello);
    }

    @Test
    void testFindByQuantitaGreaterThan() {
        Carrello carrello = new Carrello();
        carrello.setId(4);

        CarrelloDto dto = new CarrelloDto(4, 80.0, 7, 1.9);

        when(carrelloRepository.findByQuantitaGreaterThan(5)).thenReturn(List.of(carrello));
        when(carrelloMapper.toDTO(carrello)).thenReturn(dto);

        List<CarrelloDto> result = carrelloService.findByQuantitaGreaterThan(5);

        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
        verify(carrelloRepository).findByQuantitaGreaterThan(5);
        verify(carrelloMapper).toDTO(carrello);
    }

    @Test
    void testFindByPesoLessThan() {
        Carrello carrello = new Carrello();
        carrello.setId(5);

        CarrelloDto dto = new CarrelloDto(5, 30.0, 1, 0.5);

        when(carrelloRepository.findByPesoLessThan(1.0)).thenReturn(List.of(carrello));
        when(carrelloMapper.toDTO(carrello)).thenReturn(dto);

        List<CarrelloDto> result = carrelloService.findByPesoLessThan(1.0);

        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
        verify(carrelloRepository).findByPesoLessThan(1.0);
        verify(carrelloMapper).toDTO(carrello);
    }
}
