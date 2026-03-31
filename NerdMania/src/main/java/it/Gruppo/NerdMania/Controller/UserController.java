package it.Gruppo.NerdMania.Controller;

import it.Gruppo.NerdMania.DTO.UserDto;
import it.Gruppo.NerdMania.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("User")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findfindByNomeContainingIgnoreCase")
    public List<UserDto> findByNomeContainingIgnoreCase(@RequestParam ("nome") String nome) {
        return userService.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase")
    public List<UserDto>  findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(@RequestParam("nome") String  nome, @RequestParam("cognome") String cognome) {
        return userService.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(nome,cognome);
    }
    @GetMapping("/findByCognome")
    public List<UserDto> findByCognome(@RequestParam("cognome") String cognome){
        return userService.findByCognome(cognome);
    }

    @GetMapping("/findByCartaFedeltaTrue")
    public List<UserDto> findByCartaFedeltaTrue(){
        return userService.findByCartaFedeltaTrue();
    }

    @GetMapping("/findByCartaFedeltaFalse")
    public List<UserDto> findByCartaFedeltaFalse(){
        return userService.findByCartaFedeltaFalse();
    }

    @GetMapping("/exiexistsByUsername")
    public boolean exiexistsByUsername(@RequestParam("username") String username){
        return userService.exiexistsByUsername(username);
    }

    @GetMapping("/exiexistsByEmail")
    public boolean exiexistsByEmail(@RequestParam("email") String email){
        return userService.exiexistsByEmail(email);
    }

    @GetMapping("/findAllByOrderByNomeAsc")
    public List<UserDto> findAllByOrderByNomeAsc(){
        return userService.findAllByOrderByNomeAsc();
    }

    @GetMapping("/findAllByOrderByCognomeAsc")
    public List<UserDto> findAllByOrderByCognomeAsc(){
        return userService.findAllByOrderByCognomeAsc();
    }


}
