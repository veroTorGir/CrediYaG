package CrediYaG.CrediYaG.infraestructure.entryPoints;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("/login")
    public Mono<ResponseEntity<String>> login(@RequestBody LoginRequest request) {
        // Autenticación básica "hardcoded"
        if ("admin".equals(request.getUsername()) && "admin123".equals(request.getPassword())) {
            // Aquí podrías devolver un JWT en vez de texto plano
            return Mono.just(ResponseEntity.ok("Autenticación exitosa: Bienvenido admin"));
        } else {
            return Mono.just(ResponseEntity.status(401).body("Credenciales inválidas"));
        }
    }

    // DTO interno
    @Data
    public static class LoginRequest {
        private String username;
        private String password;
    }
}
