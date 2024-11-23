package model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AeropuertoNotFoundException extends RuntimeException {
    public AeropuertoNotFoundException() {
        this("Aeropuerto NO encontrado");
    }

    public AeropuertoNotFoundException(String message) {
        super(message);
    }

    public AeropuertoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
