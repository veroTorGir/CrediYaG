package CrediYaG.CrediYaG.infraestructure.mapper;

import CrediYaG.CrediYaG.domain.model.User;
import CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.userdto.UserRequest;
import CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.userdto.UserResponse;
import CrediYaG.CrediYaG.infraestructure.repository.UserData;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(UserData userData) {
        return new User(
                userData.getIdentify(),
                userData.getTypeId(),
                userData.getName(),
                userData.getLastName(),
                userData.getEmail(),
                userData.getPassword(),
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
                user.getPassword(),
                user.getSalary(),
                user.getStatus(),
                user.getRol()
        );
    }

    public User toDomain(UserResponse dto) {
        return new User(
                dto.getIdentify(),
                dto.getTypeId(),
                dto.getName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getSalary(),
                dto.getStatus(),
                dto.getRol()
        );
    }

    // ✅ MÉTODO NUEVO: Convierte UserRequest -> User
    public User toDomain(UserRequest request) {
        return new User(
                request.getIdentify(),
                request.getTypeId(),
                request.getName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                request.getSalary(),
                request.getStatus(),
                request.getRol()
        );
    }

    public UserResponse toResponse(User user) {
        UserResponse dto = new UserResponse();
        dto.setIdentify(user.getIdentify());
        dto.setTypeId(user.getTypeId());
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setSalary(user.getSalary());
        dto.setStatus(user.getStatus());
        dto.setRol(user.getRol());
        return dto;
    }
}
