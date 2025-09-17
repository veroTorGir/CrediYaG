package CrediYaG.CrediYaG.domain.useCase;

import CrediYaG.CrediYaG.domain.model.Loan;
import CrediYaG.CrediYaG.domain.model.exceptions.LoanException;
import CrediYaG.CrediYaG.domain.model.gateways.LoanGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanUseCase {

    private final LoanGateway loanGateway;

    // Aquí defines los tipos de préstamos válidos (puedes cargarlo de BD o config)
    private static final List<Integer> VALID_LOAN_TYPES = Arrays.asList(1, 2, 3, 4);

    public Mono<Loan> saveLoan(Loan loan) {
        log.info("Validating loan request for identity document: {}", loan.getIdentityDocument());

        // Validar tipo de préstamo
        if (!VALID_LOAN_TYPES.contains(loan.getLoanType())) {
            log.error("Invalid loan type: {}", loan.getLoanType());
            return Mono.error(new LoanException("Invalid loan type provided"));
        }

        // Validar monto
        if (loan.getAmount() <= 0) {
            log.error("Invalid loan amount: {}", loan.getAmount());
            return Mono.error(new LoanException("Loan amount must be greater than zero"));
        }

        // Validar plazo (termMonths)
        if (loan.getTermMonths() <= 0) {
            log.error("Invalid loan term: {}", loan.getTermMonths());
            return Mono.error(new LoanException("Loan term must be greater than zero"));
        }

        // El estado ya debe venir como pendiente (1) del mapper, pero podrías reforzar aquí
        loan.setStatus(1);

        // Guardar en la BD de forma reactiva, usando el gateway
        return loanGateway.save(loan)
                .doOnSuccess(savedLoan -> log.info("Loan saved successfully: {}", savedLoan))
                .doOnError(error -> log.error("Error saving loan: {}", error.getMessage(), error));
    }
}
