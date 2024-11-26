package model.dto;

import java.util.List;

public record AerolineaDTO(Long id,
                           String nombre,
                           String codigo_aerolinea,
                           String pais_origen,
                           List<VueloDTO> vuelos) {
}


