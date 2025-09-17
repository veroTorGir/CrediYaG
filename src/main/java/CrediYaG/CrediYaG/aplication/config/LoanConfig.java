package CrediYaG.CrediYaG.aplication.config;

import CrediYaG.CrediYaG.domain.model.gateways.LoanGateway;
import CrediYaG.CrediYaG.infraestructure.repository.LoanGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoanConfig {

    @Bean
    public LoanGateway loanGateway() {
        return new LoanGatewayImpl();
    }

}
