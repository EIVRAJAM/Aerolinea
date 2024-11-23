package dto;

import java.util.ArrayList;

public record ClienteDTO(Long id_cliente,
                         String nombre,
                         String apellidos,
                         String direccion,
                         int telefono,
                         String email,
                         ArrayList<Long> reservasIds) {
}


