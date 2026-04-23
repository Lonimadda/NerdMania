package it.Gruppo.NerdMania.Controller;

import it.Gruppo.NerdMania.DTO.CarrelloDto;
import it.Gruppo.NerdMania.Service.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Carrello")
@CrossOrigin(origins = "http://localhost:4200")
public class CarrelloController extends AbstractController<CarrelloDto> {

    @Autowired
    private CarrelloService carrelloService;

    @GetMapping("/findByUser")
    public ResponseEntity<CarrelloDto> findByUser(@RequestParam("id") Integer id) {
        CarrelloDto dto = carrelloService.findByUser(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/findCarrelliAttivi")
    public List<CarrelloDto> findCarrelliAttivi() {
        return carrelloService.findCarrelliAttivi();
    }

    @GetMapping("/findByPrezzoTotaleGreaterThan")
    public List<CarrelloDto> findByPrezzoTotaleGreaterThan(@RequestParam("prezzoTotale") Double prezzo) {
        return carrelloService.findByPrezzoTotaleGreaterThan(prezzo);
    }

    @GetMapping("/findByQuantitaGreaterThan")
    public List<CarrelloDto> findByQuantitaGreaterThan(@RequestParam("quantita") Integer quantita) {
        return carrelloService.findByQuantitaGreaterThan(quantita);
    }

    @GetMapping("/findByPesoLessThan")
    public List<CarrelloDto> findByPesoLessThan(@RequestParam("peso") Double peso) {
        return carrelloService.findByPesoLessThan(peso);
    }
}