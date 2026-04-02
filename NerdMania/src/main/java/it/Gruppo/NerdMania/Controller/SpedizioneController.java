package it.Gruppo.NerdMania.Controller;

import it.Gruppo.NerdMania.DTO.SpedizioneDto;
import it.Gruppo.NerdMania.Service.SpedizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Spedizione")
@CrossOrigin(origins = "http://localhost:8080")
public class SpedizioneController extends AbstractController<SpedizioneDto> {

    @Autowired
    private SpedizioneService service;

    @GetMapping("/findByFragileTrue")
    public List<SpedizioneDto> findByFragileTrue() {
        return service.findByFragileTrue();
    }

    @GetMapping("/findByEsteroTrue")
    public List<SpedizioneDto> findByEsteroTrue() {
        return service.findByEsteroTrue();
    }

    @GetMapping("/findByPesoGreaterThan")
    public List<SpedizioneDto> findByPesoGreaterThan(@RequestParam("peso") float peso) {
        return service.findByPesoGreaterThan(peso);
    }

    @GetMapping("/findByPesoLessThan")
    public List<SpedizioneDto> findByPesoLessThan(@RequestParam("peso") float peso) {
        return service.findByPesoLessThan(peso);
    }

    @GetMapping("/findByAltezzaBetween")
    public List<SpedizioneDto> findByAltezzaBetween(@RequestParam("min") float min,
                                                    @RequestParam("max") float max) {
        return service.findByAltezzaBetween(min,max);
    }

    @GetMapping("/findByOrdineId")
    public List<SpedizioneDto> findByOrdineId(Integer id) {
        return service.findByOrdineId(id);
    }

    @GetMapping("/findByAltezzaGreaterThanOrLunghezzaGreaterThan")
    public List<SpedizioneDto> findByAltezzaGreaterThanOrLunghezzaGreaterThan(@RequestParam float h,
                                                                              @RequestParam float l) {
        return service.findByAltezzaGreaterThanOrLunghezzaGreaterThan(h,l);
    }
}
