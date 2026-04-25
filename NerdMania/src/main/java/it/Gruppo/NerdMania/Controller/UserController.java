package it.Gruppo.NerdMania.Controller;

import it.Gruppo.NerdMania.DTO.UserDto;
import it.Gruppo.NerdMania.Mapper.UserMapper;
import it.Gruppo.NerdMania.Modelli.Ruolo;
import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("User")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends AbstractController<UserDto>{

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;


    @GetMapping("/findById")
    public UserDto findById(
            @RequestParam ("id") int id
    ) {
        return userService.findById(id);

    }
    @GetMapping("/findByNomeContainingIgnoreCase")
    public List<UserDto> findByNomeContainingIgnoreCase(@RequestParam ("nome") String nome) {
        return userService.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase")
    public List<UserDto>  findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(@RequestParam("nome") String  nome, @RequestParam("cognome") String cognome) {
        return userService.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(nome,cognome);
    }
    @GetMapping("/findByCognomeContainingIgnoreCase")
    public List<UserDto> findByCognomeContainingIgnoreCase(@RequestParam("cognome") String cognome){
        return userService.findByCognomeContainingIngnoreCase(cognome);
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

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto dto) {

        try {
            dto.setRuolo(Ruolo.USER);
            dto.setCartaFedelta(false);

            UserDto savedUser = userService.register(
                    userMapper.toEntity(dto)
            );

            return ResponseEntity.ok(savedUser);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());

        }

    }

    @PatchMapping("/updateCartaFedelta")
    public ResponseEntity<Void> updateCartaFedelta(
            @RequestParam Integer id,
            @RequestParam boolean value
    ) {
        userService.updateCartaFedelta(id, value);
        return ResponseEntity.ok().build();
    }
}
