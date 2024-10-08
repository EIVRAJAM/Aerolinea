package Dto;

import java.util.Date;
import java.util.List;

public record VueloDTO(
        Long id_vuelo,
        String origen,
        String destino,
        Date fecha_de_salida,
        Date hora_de_salida,
        Date duracion,
        String capacidad,
        List<Long> id_reservas,
        Long id_aerolinea,
        Long id_aeropuerto
) {
}
