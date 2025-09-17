package CrediYaG.CrediYaG.infraestructure.repository;

import CrediYaG.CrediYaG.domain.model.User;
import CrediYaG.CrediYaG.domain.model.gateways.UserGateway;
import CrediYaG.CrediYaG.infraestructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserMapper userMapper;
    private final UserRepository userDataRepository;


    @Override
    public Mono<User> saveUser(User user) {
        return userDataRepository.save(userMapper.toData(user))
                .map(userMapper::toDomain);
    }

    @Override
    public Mono<User> findByEmail(String email) {
        return userDataRepository.findByEmail(email)
                .map(userMapper::toDomain);
    }
}
