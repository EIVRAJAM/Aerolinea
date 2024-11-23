package model.dto;

import java.util.List;

public record AeropuertoDTO(
        int id,
        String nombre,
        String ciudad,
        String pais,
        List<VueloDTO> vuelosOrigen,
        List<VueloDTO> vuelosDestino
) {
}
