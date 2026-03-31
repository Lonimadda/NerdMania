package it.Gruppo.NerdMania.Controller;

import it.Gruppo.NerdMania.DTO.CatalogoDto;
import it.Gruppo.NerdMania.Service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Catalogo")
@CrossOrigin(origins = "http://localhost:4200")
public class CatalogoController {               //LorenzoLombardi

    @Autowired
    private CatalogoService catalogoService;

    //Trova catalogo per nome
    @GetMapping("/findByNome")
    public CatalogoDto findByNome(@RequestParam("nome") String nome) {
        return catalogoService.findByNome(nome);
    }

    //Controlla se esiste un catalogo con quel nome
    @GetMapping("/existsByNome")
    public boolean existsByNome(@RequestParam("nome") String nome) {
        return catalogoService.existsByNome(nome);
    }

    //Trova cataloghi che contengono una parola nel nome
    @GetMapping("/findByNomeContaining")
    public List<CatalogoDto> findByNomeContaining(@RequestParam("nome") String nome) {
        return catalogoService.findByNomeContaining(nome);
    }

    // 4️⃣ Trova cataloghi che iniziano con
    @GetMapping("/findByNomeStartingWith")
    public List<CatalogoDto> findByNomeStartingWith(@RequestParam("nome") String nome) {
        return catalogoService.findByNomeStartingWith(nome);
    }

    //Trova cataloghi che finiscono con
    @GetMapping("/findByNomeEndingWith")
    public List<CatalogoDto> findByNomeEndingWith(@RequestParam("nome") String nome) {
        return catalogoService.findByNomeEndingWith(nome);
    }

    //Trova cataloghi con categorie associate
    @GetMapping("/findCataloghiConCategorie")
    public List<CatalogoDto> findCataloghiConCategorie() {
        return catalogoService.findCataloghiConCategorie();
    }

    //Trova cataloghi senza categorie
    @GetMapping("/findCataloghiSenzaCategorie")
    public List<CatalogoDto> findCataloghiSenzaCategorie() {
        return catalogoService.findCataloghiSenzaCategorie();
    }

    //Trova cataloghi con più di X categorie
    @GetMapping("/findByNumeroCategorieGreaterThan")
    public List<CatalogoDto> findByNumeroCategorieGreaterThan(@RequestParam("size") int size) {
        return catalogoService.findByNumeroCategorieGreaterThan(size);
    }
}