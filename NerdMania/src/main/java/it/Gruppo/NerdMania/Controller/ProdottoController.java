package it.Gruppo.NerdMania.Controller;

import it.Gruppo.NerdMania.DTO.ProdottoDto;
import it.Gruppo.NerdMania.Service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Prodotto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdottoController extends AbstractController<ProdottoDto> {

    @Autowired
    private ProdottoService service;

    //FILTRI
    @GetMapping("/filtri")
    public Page<ProdottoDto> filtri(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Double prezzoMin,
            @RequestParam(required = false) Double prezzoMax,
            @RequestParam(required = false) Integer categoriaId,
            Pageable pageable) {

        return service.getProdottiFiltrati(
                nome, prezzoMin, prezzoMax, categoriaId, pageable);
    }

    //PAGINAZIONE
    @GetMapping("/prodotti")
    // Endpoint GET per ottenere una lista di prodotti paginata
    public Page<ProdottoDto> getProdotto(Pageable pageable) {
        // Pageable viene gestito automaticamente da :contentReference[oaicite:0]{index=0}
        // Permette di passare parametri come:
        // /prodotti?page=0&size=10&sort=nome

        return service.getProdottiPaginati(pageable);
        // Chiama il service che restituisce una pagina (Page) di prodotti
    }

    @GetMapping("/search")
    // Endpoint GET per cercare prodotti tramite una parola chiave

    public List<ProdottoDto> search(@RequestParam("keyword") String keyword) {
        // Riceve una keyword dalla URL
        // Esempio: /search?keyword=telefono

        return service.search(keyword);
        // Restituisce i prodotti che corrispondono alla ricerca
    }
    @GetMapping("/findById")

    public ProdottoDto findById(@RequestParam("id") Integer id) {

        return service.findById(id);

    }

    @GetMapping("/findProdottiEconomici")
    // Endpoint GET per trovare prodotti con prezzo <= prezzoMax

    public List<ProdottoDto> findProdottiEconomici(@RequestParam("prezzoMax") Double prezzoMax) {
        // Esempio: /findProdottiEconomici?prezzoMax=100

        return service.findProdottiEconomici(prezzoMax);
        // Restituisce i prodotti considerati economici
    }

    @GetMapping("/findProdottiCostosi")
    // Endpoint GET per trovare prodotti con prezzo >= prezzoMin

    public List<ProdottoDto> findProdottiCostosi(@RequestParam("prezzoMin") Double prezzoMin) {
        // Esempio: /findProdottiCostosi?prezzoMin=500

        return service.findProdottiCostosi(prezzoMin);
        // Restituisce i prodotti considerati costosi
    }

    @GetMapping("/findByPesoRange")
    // Endpoint GET per trovare prodotti in un intervallo di peso

    public List<ProdottoDto> findByPesoRange(@RequestParam("pesoMin") float pesoMin,
                                             @RequestParam("pesoMax") float pesoMax) {
        // Esempio: /findByPesoRange?pesoMin=1&pesoMax=5

        return service.findByPesoRange(pesoMin, pesoMax);
        // Restituisce i prodotti con peso compreso tra minimo e massimo
    }

    @GetMapping("/findAllOrderByNome")
    // Endpoint GET per ottenere tutti i prodotti ordinati per nome

    public List<ProdottoDto> findAllOrderByNome() {

        return service.findAllOrderByNome();
        // Restituisce tutti i prodotti ordinati alfabeticamente per nome
    }

    @GetMapping("/findByCategoriaId")
    // Endpoint GET per trovare prodotti appartenenti a una categoria specifica

    public List<ProdottoDto> findByCategoriaId(@RequestParam("categoriaId") Long categoriaId) {
        // Esempio: /findByCategoriaId?categoriaId=1

        return service.findByCategoriaId(categoriaId);
        // Restituisce tutti i prodotti della categoria indicata
    }

}