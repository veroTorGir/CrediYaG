package CrediYaG.CrediYaG.infraestructure.driver_adapter.jpa_repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("user_table")
public class UserData {

    @Id
    private Long identify;

    @Column("type_id")
    private String typeId;

    @Column("name")
    private String name;

    @Column("last_name")
    private String lastName;

    @Column("email")
    private String email;

    @Column("salary")
    private int salary;

    @Column("status")
    private int status;

    @Column("rol")
    private int rol;
}
