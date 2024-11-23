package model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class VueloNotFoundException extends RuntimeException {
    public VueloNotFoundException() {
        this("Vuelo NO encontrado");
    }

    public VueloNotFoundException(String message) {
        super(message);
    }

    public VueloNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}