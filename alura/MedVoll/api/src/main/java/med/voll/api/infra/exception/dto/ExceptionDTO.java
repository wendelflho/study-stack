package med.voll.api.infra.exception.dto;

import org.springframework.validation.FieldError;

public record ExceptionDTO(
        String field,
        String message
) {
    public ExceptionDTO(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}
