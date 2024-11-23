package exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AirlineNotFoundException extends RuntimeException {
    public AirlineNotFoundException() {
        this("Aerolinea NO encontrada");
    }

    public AirlineNotFoundException(String message) {
        super(message);
    }

    public AirlineNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}