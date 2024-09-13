package services;

import com.example.aerolineamodels.models.Aeropuerto;

import java.util.List;
import java.util.Optional;

public interface AeropuertoServices {

    List<Aeropuerto> obtenerTodos();

    Optional<Aeropuerto> obtenerPorId(Long id);

    Aeropuerto guardar(Aeropuerto aeropuerto);

    void eliminarPorId(Long id);

    List<Aeropuerto> buscarPorNombre(String nombre);

    List<Aeropuerto> buscarPorCiudad(String ciudad);

    Aeropuerto actualizarAeropuerto(Long id, Aeropuerto aeropuerto);
}
