package it.Gruppo.NerdMania.SpedizioneTest;

import it.Gruppo.NerdMania.DTO.OrdineDto;
import it.Gruppo.NerdMania.DTO.SpedizioneDto;
import it.Gruppo.NerdMania.Mapper.OrdineMapper;
import it.Gruppo.NerdMania.Mapper.SpedizioneMapper;
import it.Gruppo.NerdMania.Modelli.Ordine;
import it.Gruppo.NerdMania.Modelli.Spedizione;
import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Repository.OrdineRepository;
import it.Gruppo.NerdMania.Repository.SpedizioneRepository;
import it.Gruppo.NerdMania.Service.OrdineService;
import it.Gruppo.NerdMania.Service.SpedizioneService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        when(spedizioneRepository.findByFragileTrue()).thenReturn(Collections.singletonList((spedizione)));
        when(spedizioneMapper.toDTO(spedizione)).thenReturn(dto);

        List<SpedizioneDto> result = spedizioneService.findByFragileTrue();

        assertEquals(1, result.size());
        assertEquals(spedizione, result.get(0));
    }
}