package services;


import repositories.AerolineaRepository;
import models.Aerolinea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AerolineaServicesImpl implements services.AerolineaServices {

    @Autowired
    private AerolineaRepository aerolineaRepositorio;

    @Override
    public List<Aerolinea> obtenerTodas() {
        return aerolineaRepositorio.findAll();
    }

    @Override
    public Optional<Aerolinea> obtenerPorId(Long id) {
        return aerolineaRepositorio.findById(id);
    }

    @Override
    public Aerolinea guardar(Aerolinea aerolinea) {
        return aerolineaRepositorio.save(aerolinea);
    }

    @Override
    public void eliminarPorId(Long id) {
        aerolineaRepositorio.deleteById(id);
    }

    @Override
    public List<Aerolinea> buscarPorNombre(String nombre) {
        return aerolineaRepositorio.findByNombre(nombre);
    }

    @Override
    public List<Aerolinea> buscarPorPais(String pais) {
        return aerolineaRepositorio.findByPaisOrigen(pais);
    }

    @Override
    public Aerolinea actualizarAerolinea(Long id, Aerolinea aerolinea) {
        Aerolinea aerolineaExistente = aerolineaRepositorio.findById(id).orElseThrow();
        aerolineaExistente.setNombre(aerolinea.getNombre());
        aerolineaExistente.setCodigoAerolinea(aerolinea.getCodigoAerolinea());
        return aerolineaRepositorio.save(aerolineaExistente);
    }
}
