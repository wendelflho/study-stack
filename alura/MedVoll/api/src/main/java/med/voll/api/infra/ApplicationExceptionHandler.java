package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api.infra.dto.ExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handle404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handle400(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(
                errors
                        .stream()
                        .map(ExceptionDTO::new)
                        .toList()
        );
    }

}
