package Dto;

import java.util.ArrayList;

public record AerolineaDTO(Long id_aerolinea,
                           String nombre,
                           String codigoAerolinea,
                           String paisOrigen,
                           ArrayList<Long> vuelosIds) {
}


