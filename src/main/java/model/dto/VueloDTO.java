package model.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public record VueloDTO(Long id,
                       Long aerolinea_id,
                       Long aeropuertoOrigen_id,
                       Long aeropuertoDestino_id,
                       LocalDate fechaSalida,
                       Time tiempoSalida,
                       Time duracion,
                       int capacity,
                       List<Long> reservas_id) {
}
