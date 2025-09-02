package CrediYaG.CrediYaG.domain.model.gateways;

import CrediYaG.CrediYaG.domain.model.User;
import reactor.core.publisher.Mono;

public interface UserGateway {
    Mono<User> saveUser(User user);

    Mono<User> save(User user);
    Mono<Void> delete(Long id);
    Mono<User> searchId(Long id);
    Mono<User> findByEmail(String email);
}