package model.dto;

public record PasajeroDTO(Long id,
                          String nombre,
                          String apellido,
                          String telefono ,
                          String direccion,
                          String email,
                          Long reserva_id) {
}
