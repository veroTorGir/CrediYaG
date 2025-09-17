package CrediYaG.CrediYaG.domain.useCase;

import CrediYaG.CrediYaG.domain.model.User;
import CrediYaG.CrediYaG.domain.model.exceptions.UserException;
import CrediYaG.CrediYaG.domain.model.gateways.UserGateway;
import reactor.core.publisher.Mono;

public class UserUseCase {

    private final UserGateway userGateway;

    public UserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public Mono<Object> saveUser(User user) {
        if (user.getIdentify() == null) {
            return Mono.error(new IllegalArgumentException("Identify cannot be null"));
        }
        return userGateway.findByEmail(user.getEmail())
                .flatMap(existingUser -> Mono.error(new UserException("El correo electrónico ya está registrado")))
                .switchIfEmpty(
                        userGateway.saveUser(user)
                                .cast(User.class) // o map para conversión personalizada
                );
    }

    public Mono<Boolean> authenticateAdmin(String email, String password) {
        return userGateway.findByEmail(email)
                .map(user -> user.getPassword().equals(password) && user.getRol() == 1);
    }
}
