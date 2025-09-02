package CrediYaG.CrediYaG.domain.model;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
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
