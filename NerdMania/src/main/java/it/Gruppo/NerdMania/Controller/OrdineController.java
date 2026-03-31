package it.Gruppo.NerdMania.Controller;

import it.Gruppo.NerdMania.DTO.OrdineDto;
import it.Gruppo.NerdMania.Service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Ordine")
@CrossOrigin(origins = "http://localhost:8080")
public class OrdineController extends AbstractController<OrdineDto> {

    @Autowired
    private OrdineService service;

    @GetMapping("/findByUserUsername")
    public List<OrdineDto> findByUserUsername(@RequestParam("username") String username) {
        return service.findByUserUsername(username);
    }

    @GetMapping("/findAllByOrderByCostoTotaleDesc")
    public List<OrdineDto> findAllByOrderByCostoTotaleDesc() {
        return service.findAllByOrderByCostoTotaleDesc();
    }

    @GetMapping("/findAllByOrderByCostoTotaleAsc")
    public List<OrdineDto> findAllByOrderByCostoTotaleAsc() {
        return service.findAllByOrderByCostoTotaleAsc();
    }

    @GetMapping("/findByIndirizzoSpedizioneContainingIgnoreCase")
    public List<OrdineDto> findByIndirizzoSpedizioneContainingIgnoreCase(@RequestParam("testo") String testo) {
        return service.findByIndirizzoSpedizioneContainingIgnoreCase(testo);
    }

    @GetMapping("/findByCostoTotaleGreaterThan")
    public List<OrdineDto> findByCostoTotaleGreaterThan(@RequestParam("prezzo") float prezzo) {
        return service.findByCostoTotaleGreaterThan(prezzo);
    }

    @GetMapping("/findByCostoTotaleLessThan")
    public List<OrdineDto> findByCostoTotaleLessThan(@RequestParam("prezzo") float prezzo) {
        return service.findByCostoTotaleLessThan(prezzo);
    }

    @GetMapping("/findByProdottiId")
    public List<OrdineDto> findByProdottiId(@RequestParam("prodottoId") Integer prodottoId) {
        return service.findByProdottiId(prodottoId);
    }
}

