package model.dto;

import java.util.List;

public record AeropuertoDTO(
        Long id,
        String nombre,
        String ciudad,
        String pais,
        List<VueloDTO> vuelosOrigen,
        List<VueloDTO> vuelosDestino
) {
}
