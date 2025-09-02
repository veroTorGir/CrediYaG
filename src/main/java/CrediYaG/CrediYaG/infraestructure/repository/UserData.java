package CrediYaG.CrediYaG.infraestructure.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("user_table")
public class UserData {

    @Id
    private Long identify;      // 👈 Este es el ID primario

    private String typeId;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private int salary;
    private int status;
    private int rol;
}
