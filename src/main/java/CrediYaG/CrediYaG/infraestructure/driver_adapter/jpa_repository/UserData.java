package CrediYaG.CrediYaG.infraestructure.driver_adapter.jpa_repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identify;

    @Column(nullable = false)
    private String typeId;

    @Column(length = 100, nullable = false)
    private String name;

    private String lastName;
    private String email;
    private int salary;
    private int status;
    private int rol;
}

