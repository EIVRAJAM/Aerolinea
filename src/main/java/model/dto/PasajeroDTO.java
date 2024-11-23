package model.dto;

public record PasajeroDTO(int id, String nombre, String apellido, String telefono ,String direccion, String email, ReservaDTO reserva) {
}
