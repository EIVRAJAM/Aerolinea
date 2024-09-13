package services;
import Repositories.AeropuertoRepository;
import com.example.aerolineamodels.models.Aeropuerto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AeropuertoServicesImpl implements services.AeropuertoServices {

    @Autowired
    private AeropuertoRepository aeropuertoRepositorio;

    @Override
    public List<Aeropuerto> obtenerTodos() {
        return aeropuertoRepositorio.findAll();
    }

    @Override
    public Optional<Aeropuerto> obtenerPorId(Long id) {
        return aeropuertoRepositorio.findById(id);
    }

    @Override
    public Aeropuerto guardar(Aeropuerto aeropuerto) {
        return aeropuertoRepositorio.save(aeropuerto);
    }

    @Override
    public void eliminarPorId(Long id) {
        aeropuertoRepositorio.deleteById(id);
    }

    @Override
    public List<Aeropuerto> buscarPorNombre(String nombre) {
        return aeropuertoRepositorio.findByNombre(nombre);
    }

    @Override
    public List<Aeropuerto> buscarPorCiudad(String ciudad) {
        return aeropuertoRepositorio.findByCiudad(ciudad);
    }

    @Override
    public Aeropuerto actualizarAeropuerto(Long id, Aeropuerto aeropuerto) {
        Aeropuerto aeropuertoExistente = aeropuertoRepositorio.findById(id).orElseThrow();
        aeropuertoExistente.setNombre(aeropuerto.getNombre());
        aeropuertoExistente.setCiudad(aeropuerto.getCiudad());
        return aeropuertoRepositorio.save(aeropuertoExistente);
    }
}
