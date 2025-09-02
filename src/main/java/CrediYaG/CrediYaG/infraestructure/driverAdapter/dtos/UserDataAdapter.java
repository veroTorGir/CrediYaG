package CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos;

import CrediYaG.CrediYaG.domain.model.User;
import CrediYaG.CrediYaG.domain.model.gateways.UserGateway;
import CrediYaG.CrediYaG.infraestructure.mapper.UserMapper;
import CrediYaG.CrediYaG.infraestructure.repository.UserData;
import CrediYaG.CrediYaG.infraestructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserDataAdapter implements UserGateway {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Mono<User> saveUser(User user) {
        UserData userData = userMapper.toData(user);
        return userRepository.save(userData)
                .map(userMapper::toDomain);
    }

    @Override
    public Mono<User> save(User user) {
        return saveUser(user);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return userRepository.deleteById(id);
    }

    @Override
    public Mono<User> searchId(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDomain);
    }

    @Override
    public Mono<User> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDomain);
    }
}
