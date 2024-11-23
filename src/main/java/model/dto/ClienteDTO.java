package model.dto;

import java.util.List;

public record ClienteDTO(int id,
                         String nombre,
                         String apellidos,
                         String direccion,
                         int telefono,
                         String email,
                         List<ReservaDTO> reservas) {
}


