package CrediYaG.CrediYaG.aplication.config;


import CrediYaG.CrediYaG.domain.model.gateways.UserGateway;
import CrediYaG.CrediYaG.domain.useCase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public UserUseCase userUseCase(UserGateway getaway){
        return new UserUseCase(getaway);
    }
}
