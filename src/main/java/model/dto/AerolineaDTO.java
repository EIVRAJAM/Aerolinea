package model.dto;

import java.util.List;

public record AerolineaDTO(Long id,
                           String nombre,
                           String codigoAerolinea,
                           String paisOrigen,
                           List<VueloDTO> vuelos) {
}


