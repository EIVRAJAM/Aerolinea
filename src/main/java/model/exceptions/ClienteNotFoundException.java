package model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException() {this("Cliente NO encontrado");}
    public ClienteNotFoundException(String message) {
        super(message);
    }
    public ClienteNotFoundException(String message, Throwable cause) {super(message, cause);}
}
