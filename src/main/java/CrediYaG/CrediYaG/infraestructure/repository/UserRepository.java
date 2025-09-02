package CrediYaG.CrediYaG.infraestructure.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserData, Long> {
    Mono<UserData> findByEmail(String email);
}