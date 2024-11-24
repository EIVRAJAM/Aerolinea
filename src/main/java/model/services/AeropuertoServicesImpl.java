package model.services;
import lombok.AllArgsConstructor;
import model.dto.AeropuertoDTO;
import model.mappers.AeropuertoMapper;
import model.mappers.VueloMapper;
import model.repositories.AeropuertoRepository;
import model.models.Aeropuerto;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class AeropuertoServicesImpl implements AeropuertoServices {
    private AeropuertoMapper aeropuertoMapper;
    private VueloMapper vueloMapper;
    private AeropuertoRepository aeropuertoRepository;

    @Override
    public AeropuertoDTO save(AeropuertoDTO airport) {
        return aeropuertoMapper.toDto(aeropuertoRepository.save(aeropuertoMapper.toEntity(airport)));
    }

    @Override
    public Optional<AeropuertoDTO> findById(Long id) {
        return aeropuertoRepository.findById(id).map(aeropuertoMapper::toIdDto);
    }

    @Override
    public Optional<AeropuertoDTO> update(Long id, AeropuertoDTO airport) {
        return aeropuertoRepository.findById((long) id).map(oldAirport -> {
            oldAirport.setCiudad(airport.ciudad());
            oldAirport.setPais(airport.pais());
            oldAirport.setNombre(airport.nombre());
            oldAirport.setVuelosOrigen(vueloMapper.toListEntity(airport.vuelosOrigen()));
            oldAirport.setVuelosDestino(vueloMapper.toListEntity(airport.vuelosDestino()));
            return aeropuertoMapper.toIdDto(aeropuertoRepository.save(oldAirport));
        });
    }

    @Override
    public List<AeropuertoDTO> findAll() {
        return aeropuertoMapper.toListDto((ArrayList<Aeropuerto>) aeropuertoRepository.findAll());
    }

    @Override
    public List<AeropuertoDTO> findByName(String name) {
        Aeropuerto a = new Aeropuerto();
        a.setNombre(name);
        Example<Aeropuerto> example = Example.of(a);
        return aeropuertoMapper.toListDto((java.util.ArrayList<Aeropuerto>) aeropuertoRepository.findAll(example));
    }

    @Override
    public void deleteById(Long id) {
        aeropuertoRepository.deleteById((long)id);
    }

}
