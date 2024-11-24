package model.dto;

import java.util.List;

public record ClienteDTO(Long id,
                         String nombre,
                         String apellidos,
                         String direccion,
                         String telefono,
                         String email,
                         List<ReservaDTO> reservas,
                         String username) {//cambio---
}


