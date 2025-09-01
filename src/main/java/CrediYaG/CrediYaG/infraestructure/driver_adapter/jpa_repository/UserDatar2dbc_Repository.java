package CrediYaG.CrediYaG.infraestructure.driver_adapter.jpa_repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserDataRepository extends ReactiveCrudRepository<UserData, Long> {

}