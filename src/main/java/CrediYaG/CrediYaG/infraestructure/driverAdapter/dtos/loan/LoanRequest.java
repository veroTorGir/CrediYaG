package CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.solicitud;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanRequest {

    @NotBlank(message = "Identity document is required")
    private String identityDocument;

    @NotNull(message = "Loan amount is required")
    @DecimalMin(value = "100000", message = "Amount must be at least 100,000")
    @DecimalMax(value = "50000000", message = "Amount cannot exceed 50,000,000")
    private int amount;

    @NotNull(message = "Term is required")
    @Min(value = 6, message = "Minimum term is 6 months")
    @Max(value = 60, message = "Maximum term is 60 months")
    private Integer termMonths;

    @NotBlank(message = "Loan type is required")
    private String loanType;
}
