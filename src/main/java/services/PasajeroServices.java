package services;

import com.example.aerolineamodels.models.Pasajero;

import java.util.List;
import java.util.Optional;

public interface PasajeroServices {

    List<Pasajero> obtenerTodos();

    Optional<Pasajero> obtenerPorId(Long id);

    Pasajero guardar(Pasajero pasajero);

    void eliminarPorId(Long id);

    List<Pasajero> buscarPorNombre(String nombre);

    Pasajero actualizarPasajero(Long id, Pasajero pasajero);
}
