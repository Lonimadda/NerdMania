package it.Gruppo.NerdMania.SpedizioneTest;

import it.Gruppo.NerdMania.DTO.SpedizioneDto;
import it.Gruppo.NerdMania.Mapper.SpedizioneMapper;
import it.Gruppo.NerdMania.Modelli.Ordine;
import it.Gruppo.NerdMania.Modelli.Spedizione;
import it.Gruppo.NerdMania.Repository.SpedizioneRepository;
import it.Gruppo.NerdMania.Service.SpedizioneService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SpedizioneServiceTest {
    @Mock
    private SpedizioneRepository spedizioneRepository;

    @Mock
    private SpedizioneMapper spedizioneMapper;

    @InjectMocks
    private SpedizioneService spedizioneService;

    @Test
    void shouldFindByFragileTrue() {
        Spedizione spedizione = new Spedizione();
        spedizione.setFragile(true);
        SpedizioneDto dto = new SpedizioneDto();
        dto.setFragile(true);

        when(spedizioneRepository.findByFragileTrue()).thenReturn(List.of(spedizione));
        when(spedizioneMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<SpedizioneDto> result = spedizioneService.findByFragileTrue();

        assertEquals(true, result.get(0).isFragile());
    }

    @Test
    void shouldFindByEsteroTrue() {
        Spedizione spedizione = new Spedizione();
        spedizione.setEstero(true);
        SpedizioneDto dto = new SpedizioneDto();
        dto.setEstero(true);

        when(spedizioneRepository.findByEsteroTrue()).thenReturn(List.of(spedizione));
        when(spedizioneMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<SpedizioneDto> result = spedizioneService.findByEsteroTrue();

        assertEquals(true, result.get(0).isEstero());
    }

    @Test
    void shouldFindByPesoGreaterThan() {
        Spedizione spedizione = new Spedizione();
        spedizione.setPeso(11);
        SpedizioneDto dto = new SpedizioneDto();
        dto.setPeso(11);

        when(spedizioneRepository.findByPesoGreaterThan(10)).thenReturn(List.of(spedizione));
        when(spedizioneMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<SpedizioneDto> result = spedizioneService.findByPesoGreaterThan(10);

        assertEquals(11, result.get(0).getPeso());
    }

    @Test
    void shouldFindByPesoLessThan() {
        Spedizione spedizione = new Spedizione();
        spedizione.setPeso(9);
        SpedizioneDto dto = new SpedizioneDto();
        dto.setPeso(9);

        when(spedizioneRepository.findByPesoLessThan(10)).thenReturn(List.of(spedizione));
        when(spedizioneMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<SpedizioneDto> result = spedizioneService.findByPesoLessThan(10);

        assertEquals(9, result.get(0).getPeso());
    }

    @Test
    void shouldFindByAltezzaBetween() {
        Spedizione spedizione = new Spedizione();
        spedizione.setAltezza(12);
        SpedizioneDto dto = new SpedizioneDto();
        dto.setAltezza(12);

        when(spedizioneRepository.findByAltezzaBetween(10,15)).thenReturn(List.of(spedizione));
        when(spedizioneMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<SpedizioneDto> result = spedizioneService.findByAltezzaBetween(10,15);

        assertEquals(12, result.get(0).getAltezza());
    }

    @Test
    void shouldFindByOrdineId() {
        Ordine ordine= new Ordine();
        ordine.setId(1);

        Spedizione spedizione = new Spedizione();
        spedizione.setOrdine(ordine);
        SpedizioneDto dto = new SpedizioneDto();
        dto.setOrdine(ordine);

        when(spedizioneRepository.findByOrdineId(1)).thenReturn(List.of(spedizione));
        when(spedizioneMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<SpedizioneDto> result = spedizioneService.findByOrdineId(1);

        assertEquals(dto, result.get(0));
    }

    @Test
    void shouldFindByAltezzaGreaterThanOrLunghezzaGreaterThan() {
        Spedizione spedizione = new Spedizione();
        SpedizioneDto dto = new SpedizioneDto();
        spedizione.setAltezza(10);
        dto.setAltezza(10);
        spedizione.setLunghezza(15);
        dto.setLunghezza(15);

        when(spedizioneRepository.findByAltezzaGreaterThanOrLunghezzaGreaterThan(13,5)).thenReturn(List.of(spedizione));
        when(spedizioneMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<SpedizioneDto> result = spedizioneService.findByAltezzaGreaterThanOrLunghezzaGreaterThan(13,5);

        assertEquals(10, result.get(0).getAltezza());
        assertEquals(15, result.get(0).getLunghezza());
    }
}