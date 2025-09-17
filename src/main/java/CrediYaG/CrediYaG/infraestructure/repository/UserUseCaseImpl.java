package CrediYaG.CrediYaG.infraestructure.repository;

import CrediYaG.CrediYaG.domain.model.User;
import CrediYaG.CrediYaG.domain.model.exceptions.UserException;
import CrediYaG.CrediYaG.domain.model.gateways.UserGateway;
import reactor.core.publisher.Mono;

public class UserUseCaseImpl {

    private UserGateway userGateway;


    public Mono<Object> saveUser(User user) {
        return userGateway.findByEmail(user.getEmail())
                .flatMap(existingUser -> Mono.error(new UserException("El correo electrónico ya está registrado")))
                .switchIfEmpty(userGateway.saveUser(user));
    }

}
