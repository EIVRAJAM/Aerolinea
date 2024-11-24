package model.dto;

import java.util.List;
import java.util.Set;

public record SignupRequest(String nombre,
                            String apellidos,
                            String direccion,
                            String telefono,
                            List<ReservaDTO> reservas,
                            String username,
                            String password,
                            String email,
                            Set<String> roles) {
}

