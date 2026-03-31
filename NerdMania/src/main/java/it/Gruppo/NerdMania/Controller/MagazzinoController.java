package it.Gruppo.NerdMania.Controller;

import it.Gruppo.NerdMania.DTO.MagazzinoDto;
import it.Gruppo.NerdMania.Service.MagazzinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Magazzino")
@CrossOrigin(origins = "http://localhost:8080")
public class MagazzinoController extends AbstractController<MagazzinoDto> {

    @Autowired
    private MagazzinoService service;

    @GetMapping("/search")
    public List<MagazzinoDto> search(@RequestParam("keyword") String keyword) {
        return service.search(keyword);
    }

    @GetMapping("/findMagazziniConScorteBasse")
    public List<MagazzinoDto> findMagazziniConScorteBasse(@RequestParam("soglia") int soglia) {
        return service.findMagazziniConScorteBasse(soglia);
    }

    @GetMapping("/findMagazziniConScorteAlte")
    public List<MagazzinoDto> findMagazziniConScorteAlte(@RequestParam("soglia") int soglia) {
        return service.findMagazziniConScorteAlte(soglia);
    }

    @GetMapping("/findByCodice")
    public MagazzinoDto findByCodice(@RequestParam("codice") String codice) {
        return service.findByCodice(codice);
    }

    @GetMapping("/findMagazziniByProdottoId")
    public List<MagazzinoDto> findMagazziniByProdottoId(@RequestParam("prodottoId") Long prodottoId) {
        return service.findMagazziniByProdottoId(prodottoId);
    }

    @GetMapping("/findMagazziniByNomeProdotto")
    public List<MagazzinoDto> findMagazziniByNomeProdotto(@RequestParam("nome") String nome) {
        return service.findMagazziniByNomeProdotto(nome);
    }
}