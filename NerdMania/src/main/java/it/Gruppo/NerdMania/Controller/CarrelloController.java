package it.Gruppo.NerdMania.Controller;

import it.Gruppo.NerdMania.DTO.CarrelloDto;
import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Service.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Carrello")
@CrossOrigin(origins = "http://localhost:4200")
public class CarrelloController {                //LorenzoLombardi

    @Autowired
    private CarrelloService carrelloService;

    // Carrello dell’utente (oggetto)
    @GetMapping("/findByUser")
    public CarrelloDto findByUser(@RequestParam("username") String username) {
        User user = new User();
        user.setUsername(username);
        return carrelloService.findByUser(user);
    }

    //Tutti i carrelli attivi
    @GetMapping("/findCarrelliAttivi")
    public List<CarrelloDto> findCarrelliAttivi() {
        return carrelloService.findCarrelliAttivi();
    }

    //Carrelli sopra una certa soglia di prezzo (admin/statistiche)
    @GetMapping("/findByPrezzoTotaleGreaterThan")
    public List<CarrelloDto> findByPrezzoTotaleGreaterThan(@RequestParam("prezzo") Double prezzo) {
        return carrelloService.findByPrezzoTotaleGreaterThan(prezzo);
    }

    //Carrelli con quantità maggiore di X
    @GetMapping("/findByQuantitaGreaterThan")
    public List<CarrelloDto> findByQuantitaGreaterThan(@RequestParam("quantita") Integer quantita) {
        return carrelloService.findByQuantitaGreaterThan(quantita);
    }

    //Carrelli leggeri (spedizioni)
    @GetMapping("/findByPesoLessThan")
    public List<CarrelloDto> findByPesoLessThan(@RequestParam("peso") Double peso) {
        return carrelloService.findByPesoLessThan(peso);
    }

}