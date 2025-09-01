package CrediYaG.CrediYaG.domain.model.getaways;

import CrediYaG.CrediYaG.domain.model.User;
import reactor.core.publisher.Mono;

public interface UserGetaway {
    Mono<User> save(User user);
    Mono<Void> delete(Long id);
    Mono<User> searchId(Long id);
}