package CrediYaG.CrediYaG.aplication.config;


import CrediYaG.CrediYaG.domain.model.gateways.UserGateway;
import CrediYaG.CrediYaG.domain.useCase.UserUseCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UseCaseConfig {

    @Bean
    public UserUseCase userUseCase(@Qualifier("userGatewayImpl") UserGateway gateway) {
        return new UserUseCase(gateway);
    }
}

