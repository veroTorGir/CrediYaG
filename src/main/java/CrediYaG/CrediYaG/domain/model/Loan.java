package CrediYaG.CrediYaG.domain.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Loan {
    private String id;
    private String identityDocument;
    private int amount;
    private int termMonths;
    private int loanType;
    private int status;
}
