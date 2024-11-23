package model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReservaNotFoundException extends RuntimeException {
    public ReservaNotFoundException() {
        this("Reserva NO encontrada");
    }

    public ReservaNotFoundException(String message) {
        super(message);
    }

    public ReservaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}