package it.Gruppo.NerdMania.Controller;

import it.Gruppo.NerdMania.DTO.MagazzinoDto;
import it.Gruppo.NerdMania.Service.MagazzinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Magazzino")
@CrossOrigin(origins = "http://localhost:4200")
public class MagazzinoController extends AbstractController<MagazzinoDto> {

    @Autowired
    private MagazzinoService service;

    @GetMapping("/search")
    // Mappa una richiesta HTTP GET all'endpoint "/search"

    public List<MagazzinoDto> search(@RequestParam("keyword") String keyword) {
        // Riceve una parola chiave dalla richiesta
        // Esempio: /search?keyword=telefono

        return service.search(keyword);
        // Chiama il service che esegue la ricerca e restituisce i risultati
    }

    @GetMapping("/findMagazziniConScorteBasse")
    // Endpoint GET per trovare magazzini con scorte inferiori a una certa soglia

    public List<MagazzinoDto> findMagazziniConScorteBasse(@RequestParam("soglia") int soglia) {
        // Esempio: /findMagazziniConScorteBasse?soglia=10

        return service.findMagazziniConScorteBasse(soglia);
        // Restituisce i magazzini con quantità sotto la soglia
    }

    @GetMapping("/findMagazziniConScorteAlte")
    // Endpoint GET per trovare magazzini con scorte superiori a una certa soglia

    public List<MagazzinoDto> findMagazziniConScorteAlte(@RequestParam("soglia") int soglia) {
        // Esempio: /findMagazziniConScorteAlte?soglia=50

        return service.findMagazziniConScorteAlte(soglia);
        // Restituisce i magazzini con quantità sopra la soglia
    }

    @GetMapping("/findByCodice")
    // Endpoint GET per cercare un magazzino tramite codice

    public MagazzinoDto findByCodice(@RequestParam("codice") String codice) {
        // Esempio: /findByCodice?codice=ABC123

        return service.findByCodice(codice);
        // Restituisce il magazzino corrispondente al codice
    }

    @GetMapping("/findMagazziniByProdottoId")
    // Endpoint GET per trovare magazzini che contengono un prodotto specifico (tramite ID)

    public List<MagazzinoDto> findMagazziniByProdottoId(@RequestParam("prodottoId") Long prodottoId) {
        // Esempio: /findMagazziniByProdottoId?prodottoId=1

        return service.findMagazziniByProdottoId(prodottoId);
        // Restituisce tutti i magazzini che contengono quel prodotto
    }

    @GetMapping("/findMagazziniByNomeProdotto")
    // Endpoint GET per trovare magazzini in base al nome del prodotto

    public List<MagazzinoDto> findMagazziniByNomeProdotto(@RequestParam("nome") String nome) {
        // Esempio: /findMagazziniByNomeProdotto?nome=telefono

        return service.findMagazziniByNomeProdotto(nome);
        // Restituisce i magazzini che contengono prodotti con quel nome
    }
}