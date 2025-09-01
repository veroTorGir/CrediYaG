package CrediYaG.CrediYaG.aplication.config;


import CrediYaG.CrediYaG.domain.model.getaways.UserGetaway;
import CrediYaG.CrediYaG.domain.useCase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public UserUseCase userUseCase(UserGetaway getaway){
        return new UserUseCase(getaway);
    }
}
