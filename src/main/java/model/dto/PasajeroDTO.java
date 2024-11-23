package dto;

public record PasajeroDTO(
        Long id_pasajero,
        String nombre,
        String apellido,
        String telefono,
        int cedula,
        Long id_reserva
) {
}
