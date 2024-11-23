package model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AerolineaNotFoundException extends RuntimeException {
    public AerolineaNotFoundException() {
        this("Aerolinea NO encontrada");
    }

    public AerolineaNotFoundException(String message) {
        super(message);
    }

    public AerolineaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}