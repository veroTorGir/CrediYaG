package CrediYaG.CrediYaG.domain.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserCreationException.class)
    public ResponseEntity<ErrorResponse> handleUserCreationException(UserCreationException ex) {
        ErrorResponse error = new ErrorResponse("No se pudo registrar el usuario", ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Clase interna o puedes moverla a su propio archivo
    public static class ErrorResponse {
        public final String mensaje;
        public final String detalle;

        public ErrorResponse(String mensaje, String detalle) {
            this.mensaje = mensaje;
            this.detalle = detalle;
        }
    }
}
