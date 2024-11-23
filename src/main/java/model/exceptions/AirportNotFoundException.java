package exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException() {
        this("Aeropuerto NO encontrado");
    }

    public AirportNotFoundException(String message) {
        super(message);
    }

    public AirportNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
