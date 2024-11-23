package model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PasajeroNotFoundException extends RuntimeException {
    public PasajeroNotFoundException() {
        this("Pasajero NO encontrado");
    }

    public PasajeroNotFoundException(String message) {
        super(message);
    }

    public PasajeroNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}