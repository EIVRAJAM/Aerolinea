package services;

import com.example.aerolineamodels.models.Aerolinea;

import java.util.List;
import java.util.Optional;

public interface AerolineaServices {

    List<Aerolinea> obtenerTodas();

    Optional<Aerolinea> obtenerPorId(Long id);

    Aerolinea guardar(Aerolinea aerolinea);

    void eliminarPorId(Long id);

    List<Aerolinea> buscarPorNombre(String nombre);

    List<Aerolinea> buscarPorPais(String pais);

    Aerolinea actualizarAerolinea(Long id, Aerolinea aerolinea);
}
