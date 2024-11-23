package dto;

import java.time.LocalDateTime;
import java.util.List;

public record ReservaDTO(
        Long id_reserva,
        List<Long> id_pasajeros,
        LocalDateTime fechaReserva,
        int numeroPasajeros,
        List<Long> id_vuelos
) {
}
