package services;

import Repositories.VueloRepository;
import com.example.aerolineamodels.models.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloServicesImpl implements services.VueloServices {

    @Autowired
    private VueloRepository vueloRepositorio;

    @Override
    public List<Vuelo> obtenerTodos() {
        return vueloRepositorio.findAll();
    }

    @Override
    public Optional<Vuelo> obtenerPorId(Long id) {
        return vueloRepositorio.findById(id);
    }

    @Override
    public Vuelo guardar(Vuelo vuelo) {
        return vueloRepositorio.save(vuelo);
    }

    @Override
    public void eliminarPorId(Long id) {
        vueloRepositorio.deleteById(id);
    }

    @Override
    public List<Vuelo> buscarPorOrigen(String origen) {
        return vueloRepositorio.findByOrigen(origen);
    }

    @Override
    public Vuelo actualizarVuelo(Long id, Vuelo vuelo) {
        Vuelo vueloExistente = vueloRepositorio.findById(id).orElseThrow();
        vueloExistente.setOrigen(vuelo.getOrigen());
        vueloExistente.setDestino(vuelo.getDestino());
        return vueloRepositorio.save(vueloExistente);
    }
}
