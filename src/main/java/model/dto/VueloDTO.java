package model.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public record VueloDTO(Long id,
                       Long aerolinea_id,
                       Long aeropuertoOrigen_id,
                       Long aeropuertoDestino_id,
                       LocalDate fecha_salida,
                       Time hora_salida,
                       Time duracion,
                       int capacidad,
                       Float precio,
                       List<Long> reservas_id) {
}
