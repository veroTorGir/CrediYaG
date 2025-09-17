package CrediYaG.CrediYaG.infraestructure.entryPoints.Controller;


import CrediYaG.CrediYaG.domain.model.Loan;
import CrediYaG.CrediYaG.domain.useCase.LoanUseCase;
import CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.loan.LoanRequest;
import CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.loan.LoanResponse;
import CrediYaG.CrediYaG.infraestructure.mapper.LoanMapper;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/loan")
@RequiredArgsConstructor
@Slf4j
public class LoanController {

    private final LoanUseCase loanUseCase;
    private final LoanMapper loanMapper;

    @PostMapping
    public Mono<ResponseEntity<LoanResponse>> createLoan(@Valid @RequestBody LoanRequest loanRequest) {
        Loan loanDomain = loanMapper.toDomain(loanRequest);

        return loanUseCase.saveLoan(loanDomain)
                .map(savedLoan -> {
                    log.info("Loan request registered successfully: {}", savedLoan);
                    LoanResponse response = loanMapper.toResponse(savedLoan);
                    return ResponseEntity.status(HttpStatus.CREATED).body(response);
                })
                .onErrorResume(e -> {
                    log.error("Error registering loan request: {}", e.getMessage(), e);

                    return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(new LoanResponse(null, 0, e.getMessage()))
                    );

                });
    }
}
