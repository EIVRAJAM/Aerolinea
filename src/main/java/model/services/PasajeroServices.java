package services;

import models.Pasajero;

import java.util.List;
import java.util.Optional;

public interface PasajeroServices {

    List<Pasajero> obtenerTodos();

    Optional<Pasajero> obtenerPorId(Long id);

    Pasajero guardar(Pasajero pasajero);

    void eliminarPorId(Long id);

    List<Pasajero> buscarPorNombre(String nombre);

    List<Pasajero> buscarPorCedula(int cedula);

    Pasajero actualizarPasajero(Long id, Pasajero pasajero);
}
