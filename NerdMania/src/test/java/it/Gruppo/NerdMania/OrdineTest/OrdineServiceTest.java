package it.Gruppo.NerdMania.OrdineTest;

import it.Gruppo.NerdMania.DTO.OrdineDto;
import it.Gruppo.NerdMania.Mapper.OrdineMapper;
import it.Gruppo.NerdMania.Modelli.Ordine;
import it.Gruppo.NerdMania.Modelli.Prodotto;
import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Repository.OrdineRepository;
import it.Gruppo.NerdMania.Service.OrdineService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrdineServiceTest {
    @Mock
    private OrdineRepository ordineRepository;

    @Mock
    private OrdineMapper ordineMapper;

    @InjectMocks
    private OrdineService ordineService;

    @Test
    void shouldFindByUserUsername() {
        User user= new User();
        user.setUsername("adinolfi");

        Ordine ordine = new Ordine();
        ordine.setUser(user);
        OrdineDto dto = new OrdineDto();
        dto.setUser(user);

        Ordine ordine1 = new Ordine();
        ordine1.setUser(user);
        OrdineDto dto1 = new OrdineDto();
        dto1.setUser(user);

        List<Ordine> ordini = List.of(ordine, ordine1);
        List<OrdineDto> dtos = List.of(dto,dto1);

        when(ordineRepository.findByUserUsername("adinolfi")).thenReturn((ordini));
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.findByUserUsername("adinolfi");

        assertEquals(2, result.size());
        assertEquals("adinolfi", result.get(0).getUser().getUsername());
        assertEquals("adinolfi", result.get(1).getUser().getUsername());
    }

    @Test
    void shouldFindAllByOrderByCostoTotaleDesc() {
        Ordine ordine1 = new Ordine();
        ordine1.setCostoTotale(100);
        OrdineDto dto1 = new OrdineDto();
        dto1.setCostoTotale(100);

        Ordine ordine2 = new Ordine();
        ordine2.setCostoTotale(50);
        OrdineDto dto2 = new OrdineDto();
        dto2.setCostoTotale(50);

        Ordine ordine3 = new Ordine();
        ordine3.setCostoTotale(10);
        OrdineDto dto3 = new OrdineDto();
        dto3.setCostoTotale(10);

        List<Ordine> ordini = List.of(ordine1, ordine2, ordine3);
        List<OrdineDto> dtos = List.of(dto1, dto2, dto3);

        when(ordineRepository.findAllByOrderByCostoTotaleDesc()).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.findAllByOrderByCostoTotaleDesc();

        assertEquals(3, result.size());
        assertEquals(100, result.get(0).getCostoTotale());
        assertEquals(50, result.get(1).getCostoTotale());
        assertEquals(10, result.get(2).getCostoTotale());
    }

    @Test
    void shouldFindAllByOrderByCostoTotaleAsc() {
        Ordine ordine1 = new Ordine();
        ordine1.setCostoTotale(10);
        OrdineDto dto1 = new OrdineDto();
        dto1.setCostoTotale(10);

        Ordine ordine2 = new Ordine();
        ordine2.setCostoTotale(50);
        OrdineDto dto2 = new OrdineDto();
        dto2.setCostoTotale(50);

        Ordine ordine3 = new Ordine();
        ordine3.setCostoTotale(100);
        OrdineDto dto3 = new OrdineDto();
        dto3.setCostoTotale(100);

        List<Ordine> ordini = List.of(ordine1, ordine2, ordine3);
        List<OrdineDto> dtos = List.of(dto1, dto2, dto3);

        when(ordineRepository.findAllByOrderByCostoTotaleAsc()).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.findAllByOrderByCostoTotaleAsc();

        assertEquals(3, result.size());
        assertEquals(10, result.get(0).getCostoTotale());
        assertEquals(50, result.get(1).getCostoTotale());
        assertEquals(100, result.get(2).getCostoTotale());
    }

    @Test
    void shouldFindByIndirizzoSpedizioneContainingIgnoreCase() {
        Ordine ordine = new Ordine();
        ordine.setIndirizzoSpedizione("via manzoni");
        OrdineDto dto = new OrdineDto();
        dto.setIndirizzoSpedizione("via manzoni");

        Ordine ordine1 = new Ordine();
        ordine1.setIndirizzoSpedizione("via roma");
        OrdineDto dto1 = new OrdineDto();
        dto1.setIndirizzoSpedizione("via roma");

        List<Ordine> ordini = List.of(ordine, ordine1);
        List<OrdineDto> dtos = List.of(dto, dto1);

        when(ordineRepository.findByIndirizzoSpedizioneContainingIgnoreCase("via manzoni")).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.findByIndirizzoSpedizioneContainingIgnoreCase("via manzoni");

        assertEquals(2, result.size());
        assertEquals("via manzoni", result.get(0).getIndirizzoSpedizione());
        assertEquals("via roma", result.get(1).getIndirizzoSpedizione());
    }

    @Test
    void shouldFindByCostoTotaleGreaterThan() {
        Ordine ordine = new Ordine();
        ordine.setCostoTotale(100);
        OrdineDto dto = new OrdineDto();
        dto.setCostoTotale(100);

        Ordine ordine1 = new Ordine();
        ordine1.setCostoTotale(150);
        OrdineDto dto1 = new OrdineDto();
        dto1.setCostoTotale(150);

        List<Ordine> ordini = List.of(ordine, ordine1);
        List<OrdineDto> dtos = List.of(dto, dto1);

        when(ordineRepository.findByCostoTotaleGreaterThan(99)).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.findByCostoTotaleGreaterThan(99);

        assertEquals(2, result.size());
        assertEquals(100, result.get(0).getCostoTotale());
        assertEquals(150, result.get(1).getCostoTotale());
    }

    @Test
    void shouldFindByCostoTotaleLessThan() {
        Ordine ordine = new Ordine();
        ordine.setCostoTotale(100);
        OrdineDto dto = new OrdineDto();
        dto.setCostoTotale(100);

        Ordine ordine1 = new Ordine();
        ordine1.setCostoTotale(150);
        OrdineDto dto1 = new OrdineDto();
        dto1.setCostoTotale(150);

        List<Ordine> ordini = List.of(ordine, ordine1);
        List<OrdineDto> dtos = List.of(dto, dto1);

        when(ordineRepository.findByCostoTotaleLessThan(151)).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.findByCostoTotaleLessThan(151);

        assertEquals(2, result.size());
        assertEquals(100, result.get(0).getCostoTotale());
        assertEquals(150, result.get(1).getCostoTotale());
    }

    @Test
    void shouldFindByProdottiId() {
        Prodotto prodotto= new Prodotto();
        prodotto.setId(1);
        Prodotto prodotto1= new Prodotto();
        prodotto1.setId(2);

        List<Prodotto> prodotti= new ArrayList<>();
        prodotti.add(prodotto);
        prodotti.add(prodotto1);

        Ordine ordine = new Ordine();
        ordine.setProdotti(prodotti);
        OrdineDto dto = new OrdineDto();
        dto.setProdotti(prodotti);

        Ordine ordine1 = new Ordine();
        ordine1.setProdotti(prodotti);
        OrdineDto dto1 = new OrdineDto();
        dto1.setProdotti(prodotti);

        List<Ordine> ordini = List.of(ordine, ordine1);
        List<OrdineDto> dtos = List.of(dto,dto1);

        when(ordineRepository.findByProdottiId(1)).thenReturn((ordini));
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.findByProdottiId(1);

        assertEquals(2, result.size());
        assertEquals(true, result.get(0).getProdotti().contains(prodotto));
        assertEquals(true, result.get(1).getProdotti().contains(prodotto));
    }
}
