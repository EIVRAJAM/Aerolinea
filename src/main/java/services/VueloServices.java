package services;

import com.example.aerolineamodels.models.Vuelo;

import java.util.List;
import java.util.Optional;

public interface VueloServices {

    List<Vuelo> obtenerTodos();

    Optional<Vuelo> obtenerPorId(Long id);

    Vuelo guardar(Vuelo vuelo);

    void eliminarPorId(Long id);

    List<Vuelo> buscarPorOrigen(String origen);

    Vuelo actualizarVuelo(Long id, Vuelo vuelo);
}
