package CrediYaG.CrediYaG.infraestructure.entryPoints;

import CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.userdto.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<String>> login(@RequestBody UserRequest request) {
        return authService.authenticate(request.getName(), request.getPassword())
                .map(token -> ResponseEntity.ok(token))
                .defaultIfEmpty(ResponseEntity.status(401).body("Credenciales inválidas"));
    }
}
