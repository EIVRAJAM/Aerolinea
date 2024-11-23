package model.services;

import lombok.AllArgsConstructor;
import model.dto.VueloDTO;
import model.mappers.AerolineaMapper;
import model.mappers.AeropuertoMapper;
import model.mappers.ReservaMapper;
import model.mappers.VueloMapper;
import model.models.Vuelo;
import model.repositories.VueloRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class VueloServicesImpl implements VueloServices {
    private final VueloMapper vueloMapper;
    private final AerolineaMapper aerolineaMapper;
    private final ReservaMapper reservaMapper;
    private final AeropuertoMapper aeropuertoMapper;
    VueloRepository vueloRepository;

    @Override
    public VueloDTO save(VueloDTO flight) {
        return vueloMapper.toIdDto(vueloRepository.save(vueloMapper.toEntity(flight)));
    }

    @Override
    public Optional<VueloDTO> findById(int id) {
        return vueloRepository.findById(id).map(vueloMapper::toIdDto);
    }

    @Override
    public Optional<VueloDTO> update(int id, VueloDTO flight) {
        return vueloRepository.findById(id).map(oldFlight ->{
            oldFlight.setTiempo_salida(flight.tiempoSalida());
            oldFlight.setAerolinea(aerolineaMapper.toEntity(flight.aerolinea()));
            oldFlight.setReservas(reservaMapper.toListEntity(flight.reservas()));
            oldFlight.setDuracion(flight.duracion());
            oldFlight.setCapacidad(flight.capacity());
            oldFlight.setAeropuertoDestino(aeropuertoMapper.toEntity(flight.aeropuertoDestino()));
            oldFlight.setAeropuertoOrigen(aeropuertoMapper.toEntity(flight.aeropuertoOrigen()));
            oldFlight.setFecha_salida(flight.fechaSalida());
            return vueloMapper.toIdDto(vueloRepository.save(oldFlight));
        });
    }

    @Override
    public List<VueloDTO> findAll() {
        return vueloMapper.toListIdDto(vueloRepository.findAll());
    }

    @Override
    public List<VueloDTO> findByDate(LocalDate date) {
        Vuelo f = new Vuelo();
        f.setFecha_salida(date);
        Example<Vuelo> example = Example.of(f);
        return vueloMapper.toListIdDto(vueloRepository.findAll(example));
    }

    @Override
    public void deleteById(int id) {
        vueloRepository.deleteById(id);
    }
}
