package CrediYaG.CrediYaG.domain.useCase;

import CrediYaG.CrediYaG.domain.model.User;
import CrediYaG.CrediYaG.domain.model.getaways.UserGetaway;


import reactor.core.publisher.Mono;

public class UserUseCase {
    private final UserGetaway userGetaway;

    public UserUseCase(UserGetaway userGetaway) {
        this.userGetaway = userGetaway;
    }

    public Mono<User> saveUser(User user) throws Exception {
        if (user.getIdentify() == null) {
            throw new Exception();
        }
        return userGetaway.save(user);  // Devuelve Mono<User>
    }

    public Mono<Void> deleteForId(Long id) {
        return userGetaway.delete(id);  // También reactivo
    }

    public Mono<User> searchId(Long id) {
        return userGetaway.searchId(id);
    }
}
