package CrediYaG.CrediYaG.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long identify;
    private String typeId;
    private String name;
    private String lastName;
    private String email;
    private int salary;
    private int status;


}
