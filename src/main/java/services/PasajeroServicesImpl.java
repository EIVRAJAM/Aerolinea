package services;

import Repositories.PasajeroRepository;
import com.example.aerolineamodels.models.Pasajero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroServicesImpl implements services.PasajeroServices {

    @Autowired
    private PasajeroRepository pasajeroRepositorio;

    @Override
    public List<Pasajero> obtenerTodos() {
        return pasajeroRepositorio.findAll();
    }

    @Override
    public Optional<Pasajero> obtenerPorId(Long id) {
        return pasajeroRepositorio.findById(id);
    }

    @Override
    public Pasajero guardar(Pasajero pasajero) {
        return pasajeroRepositorio.save(pasajero);
    }

    @Override
    public void eliminarPorId(Long id) {
        pasajeroRepositorio.deleteById(id);
    }

    @Override
    public List<Pasajero> buscarPorNombre(String nombre) {
        return pasajeroRepositorio.findByNombre(nombre);
    }

    @Override
    public Pasajero actualizarPasajero(Long id, Pasajero pasajero) {
        Pasajero pasajeroExistente = pasajeroRepositorio.findById(id).orElseThrow();
        pasajeroExistente.setNombre(pasajero.getNombre());
        pasajeroExistente.setApellido(pasajero.getApellido());
        return pasajeroRepositorio.save(pasajeroExistente);
    }
}
