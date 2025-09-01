package CrediYaG.CrediYaG.infraestructure.driver_adapter.mapper;

import CrediYaG.CrediYaG.domain.model.User;
import CrediYaG.CrediYaG.infraestructure.driver_adapter.jpa_repository.UserData;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserData userData) {
        return new User(
                userData.getIdentify(),
                userData.getTypeId(),
                userData.getName(),
                userData.getLastName(),
                userData.getEmail(),
                userData.getSalary(),
                userData.getStatus(),
                userData.getRol()
        );
    }

    public UserData toData(User user) {
        return new UserData(
                user.getIdentify(),
                user.getTypeId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getSalary(),
                user.getStatus(),
                user.getRol()
        );
    }
}

