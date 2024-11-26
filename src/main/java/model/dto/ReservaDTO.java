package model.dto;

import java.time.LocalDate;
import java.util.List;

public record ReservaDTO(Long id,
                         LocalDate fecha,
                         int numeroPasajeros,
                         Long cliente_id,
                         List<PasajeroDTO> pasajeros,
                         List<Long> vuelos_ids) {
}
