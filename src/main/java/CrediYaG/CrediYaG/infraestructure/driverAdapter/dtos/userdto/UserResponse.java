package CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.userdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class UserResponse {
        private Long identify;
        private String typeId;
        private String name;
        private String lastName;
        private String email;
        private String password;
        private int salary;
        private int status;
        private int rol;
    }


