package CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.userdto;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class UserRequest {

    private Long identify;

    private String typeId;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico no tiene un formato válido")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    @Min(value = 0, message = "El salario debe ser mayor o igual a 0")
    @Max(value = 15000000, message = "El salario no puede ser mayor a 15,000,000")
    private int salary;

    @Min(value = 0, message = "El estado debe ser un número válido")
    private int status;

    @Min(value = 1, message = "El rol debe ser un número válido")
    private int rol;
}
