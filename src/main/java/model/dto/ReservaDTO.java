package model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record ReservaDTO(int id, LocalDate fecha, int numeroPasajeros, ClienteDTO cliente, List<PasajeroDTO> pasajeros, List<VueloDTO> vuelos) {
}
