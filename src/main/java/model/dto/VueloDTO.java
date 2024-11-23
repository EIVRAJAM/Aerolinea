package model.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public record VueloDTO(int id,
                       AerolineaDTO aerolinea,
                       AeropuertoDTO aeropuertoOrigen,
                       AeropuertoDTO aeropuertoDestino,
                       LocalDate fechaSalida,
                       Time tiempoSalida,
                       Time duracion,
                       int capacity,
                       List<ReservaDTO> reservas) {
}
