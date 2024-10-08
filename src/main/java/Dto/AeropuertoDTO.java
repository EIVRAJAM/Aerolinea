package Dto;

import java.util.List;

public record AeropuertoDTO(
        Long id_aeropuerto,
        String nombre,
        String ciudad,
        String pais,
        List<Long> id_vuelos
) {
}
