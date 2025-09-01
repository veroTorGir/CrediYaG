package CrediYaG.CrediYaG.infraestructure.repository;

import CrediYaG.CrediYaG.domain.model.User;
import CrediYaG.CrediYaG.domain.model.gateways.UserGateway;
import CrediYaG.CrediYaG.infraestructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
class UserGatewayImpl implements UserGateway {

    private final UserMapper userMapper;
    private final UserDataRepository userDataRepository;

    @Override
    public Mono<User> save(User user) {
        return userDataRepository.save(userMapper.toEntity(user))
                .map(userMapper::toDomain);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return userDataRepository.deleteById(id);
    }

    @Override
    public Mono<User> searchId(Long id) {
        return userDataRepository.findById(id)
                .map(userMapper::toDomain);
    }

    @Override
    public Mono<User> findByEmail(String email) {
        return null;
    }
}
