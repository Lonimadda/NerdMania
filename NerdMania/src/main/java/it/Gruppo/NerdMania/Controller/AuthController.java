package it.Gruppo.NerdMania.Controller;

import it.Gruppo.NerdMania.DTO.LoginRequest;
import it.Gruppo.NerdMania.DTO.LoginResponse;
import it.Gruppo.NerdMania.DTO.UserDto;
import it.Gruppo.NerdMania.Mapper.UserMapper;
import it.Gruppo.NerdMania.Modelli.User;
import it.Gruppo.NerdMania.Service.JwtService;
import it.Gruppo.NerdMania.Service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Profile("secure")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;
    private final UserMapper userMapper;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtService jwtService, UserService userService, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token = jwtService.generateToken(request.getUsername());

        User user =
                userService
                        .findByUsername(request.getUsername())
                        .orElseThrow();

        UserDto dto =
                userMapper.toDTO(user);

        return ResponseEntity.ok(
                new LoginResponse("LOGIN_OK", token, dto)
        );
    }
}