package model.dto;

import java.util.List;

public record AerolineaDTO(int id,
                           String nombre,
                           String codigoAerolinea,
                           String paisOrigen,
                           List<VueloDTO> vuelos) {
}


