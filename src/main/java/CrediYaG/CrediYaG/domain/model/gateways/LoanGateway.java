package CrediYaG.CrediYaG.domain.model.gateways;

import CrediYaG.CrediYaG.domain.model.Loan;
import reactor.core.publisher.Mono;

public interface LoanGateway {

    Mono<Loan> save(Loan loan);


}
