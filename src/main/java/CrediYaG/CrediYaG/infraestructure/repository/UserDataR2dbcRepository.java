package CrediYaG.CrediYaG.infraestructure.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserDataRepository extends ReactiveCrudRepository<UserData, Long> {

}