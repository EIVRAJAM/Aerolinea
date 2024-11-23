package exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PassengerNotFoundException extends RuntimeException {
    public PassengerNotFoundException() {
        this("Pasajero NO encontrado");
    }

    public PassengerNotFoundException(String message) {
        super(message);
    }

    public PassengerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}