package it.Gruppo.NerdMania.Controller;

import it.Gruppo.NerdMania.DTO.ProdottoDto;
import it.Gruppo.NerdMania.Service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Prodotto")
@CrossOrigin(origins = "http://localhost:8080")
public class ProdottoController extends AbstractController<ProdottoDto> {

    @Autowired
    private ProdottoService service;

    @GetMapping("/search")
    public List<ProdottoDto> search(@RequestParam("keyword") String keyword) {
        return service.search(keyword);
    }

    @GetMapping("/findProdottiEconomici")
    public List<ProdottoDto> findProdottiEconomici(@RequestParam("prezzoMax") Double prezzoMax) {
        return service.findProdottiEconomici(prezzoMax);
    }

    @GetMapping("/findProdottiCostosi")
    public List<ProdottoDto> findProdottiCostosi(@RequestParam("prezzoMin") Double prezzoMin) {
        return service.findProdottiCostosi(prezzoMin);
    }

    @GetMapping("/findByPesoRange")
    public List<ProdottoDto> findByPesoRange(@RequestParam("pesoMin") float pesoMin,
                                             @RequestParam("pesoMax") float pesoMax) {
        return service.findByPesoRange(pesoMin, pesoMax);
    }

    @GetMapping("/findAllOrderByNome")
    public List<ProdottoDto> findAllOrderByNome() {
        return service.findAllOrderByNome();
    }

    @GetMapping("/findByCategoriaId")
    public List<ProdottoDto> findByCategoriaId(@RequestParam("categoriaId") Long categoriaId) {
        return service.findByCategoriaId(categoriaId);
    }
}