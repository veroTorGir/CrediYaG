package CrediYaG.CrediYaG.infraestructure.entryPoints;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthService {
    public Mono<String> authenticate(String username, String password) {
        if ("admin".equals(username) && "admin123".equals(password)) {
            return Mono.just("Autenticación exitosa: Bienvenido admin");
        } else {
            return Mono.empty();
        }
    }
}
