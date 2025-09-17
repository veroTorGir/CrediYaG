package CrediYaG.CrediYaG.infraestructure.entryPoints.Controller;

import CrediYaG.CrediYaG.domain.model.User;
import CrediYaG.CrediYaG.domain.model.exceptions.UserCreationException;
import CrediYaG.CrediYaG.domain.useCase.UserUseCase;
import CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.userdto.UserRequest;
import CrediYaG.CrediYaG.infraestructure.driverAdapter.dtos.userdto.UserResponse;
import CrediYaG.CrediYaG.infraestructure.entryPoints.AuthService;
import CrediYaG.CrediYaG.infraestructure.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserUseCase userUseCase;
    private final UserMapper userMapper;

    @PostMapping
    public Mono<ResponseEntity<UserResponse>> createUser(@Valid @RequestBody UserRequest dto) {

        User userDomain = userMapper.toDomain(dto);


        return userUseCase.saveUser(userDomain)
                .map(savedUser -> {
                    log.info("Usuario registrado exitosamente: {}", savedUser);
                    UserResponse response = userMapper.toResponse((User) savedUser);
                    return ResponseEntity.status(HttpStatus.CREATED).body(response);
                })
                .onErrorResume(e -> {
                    log.error("Error al registrar usuario: {}", e.getMessage(), e);
                    return Mono.error(new UserCreationException("No se pudo registrar el usuario", e));
                });
    }

    private final AuthService authService;

    @PostMapping("/login")
    public Mono<ResponseEntity<String>> login(@RequestBody UserRequest request) {
        return authService.authenticate(request.getName(), request.getPassword())
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(401).body("Credenciales inválidas"));
    }
}
