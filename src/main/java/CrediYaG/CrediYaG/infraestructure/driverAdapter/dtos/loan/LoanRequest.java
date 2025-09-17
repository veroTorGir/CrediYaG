package CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.loan;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoanRequest {
    @NotBlank(message = "Identity document is required")
    private String identityDocument;

    @Min(value = 1, message = "Amount must be greater than zero")
    private int amount;

    @Min(value = 1, message = "Term must be at least 1 month")
    private int termMonths;

    private int loanType;
}
