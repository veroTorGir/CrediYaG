package CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.loan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponse {
    private String id;
    private int status;
    private String message;
}
