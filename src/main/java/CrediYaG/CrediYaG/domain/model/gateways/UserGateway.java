package CrediYaG.CrediYaG.domain.model.gateways;

import CrediYaG.CrediYaG.domain.model.User;
import reactor.core.publisher.Mono;

public interface UserGateway {
    Mono<User> saveUser(User user);
    Mono<User> findByEmail(String email);
}