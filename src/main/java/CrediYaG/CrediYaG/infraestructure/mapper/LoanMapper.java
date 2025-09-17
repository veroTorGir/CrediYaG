package CrediYaG.CrediYaG.infraestructure.mapper;


import CrediYaG.CrediYaG.domain.model.Loan;
import CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.loan.LoanRequest;
import CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.loan.LoanResponse;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public Loan toDomain(LoanRequest dto) {
        return Loan.builder()
                .identityDocument(dto.getIdentityDocument())
                .amount(dto.getAmount())
                .termMonths(dto.getTermMonths())
                .loanType(dto.getLoanType())
                .status(1)
                .build();
    }

    public LoanResponse toResponse(Loan loan) {
        return new LoanResponse(
        );
    }
}
