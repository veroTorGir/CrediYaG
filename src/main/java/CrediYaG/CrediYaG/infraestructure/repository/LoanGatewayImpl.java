package CrediYaG.CrediYaG.infraestructure.repository;

import CrediYaG.CrediYaG.domain.model.Loan;
import CrediYaG.CrediYaG.domain.model.gateways.LoanGateway;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class LoanGatewayImpl implements LoanGateway {
    @Override
    public Mono<Loan> save(Loan loan) {
        return null;
    }

}

