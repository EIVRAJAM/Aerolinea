package services;

import models.Vuelo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VueloServices {

    List<Vuelo> obtenerTodos();

    Optional<Vuelo> obtenerPorId(Long id);

    Vuelo guardar(Vuelo vuelo);

    void eliminarPorId(Long id);

    List<Vuelo> buscarPorOrigen(String origen);

    List<Vuelo> buscarPorDestino(String destino);

    List<Vuelo> buscarPorFechaDeSalida(Date fechaDeSalida);

    Vuelo actualizarVuelo(Long id, Vuelo vuelo);
}
