package model.services;

import lombok.AllArgsConstructor;
import model.dto.VueloDTO;
import model.mappers.AerolineaMapper;
import model.mappers.AeropuertoMapper;
import model.mappers.ReservaMapper;
import model.mappers.VueloMapper;
import model.models.Vuelo;
import model.repositories.ReservaRepository;
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
    ReservaRepository reservaRepository;

    @Override
    public VueloDTO save(VueloDTO flight) {//fUNCIONA
        return vueloMapper.toIdDto(vueloRepository.save(vueloMapper.toEntity(flight)));//SIRVE
    }

    @Override
    public Optional<VueloDTO> findById(Long id) {
        return vueloRepository.findById(id).map(vueloMapper::toIdDto);//SSSSSSSSSSS
    }

    @Override
    public Optional<VueloDTO> update(Long id, VueloDTO flight) {
        return vueloRepository.findById(id).map(oldFlight ->{
            if(flight.hora_salida() != null) { oldFlight.setHora_salida(flight.hora_salida()); }
            if(flight.aerolinea_id() != null) { oldFlight.setAerolinea(aerolineaMapper.toEntity(flight.aerolinea_id())); }
            if(flight.reservas_id() != null) { oldFlight.setReservas(reservaRepository.findAllById(flight.reservas_id())); }
            if(flight.duracion() != null) { oldFlight.setDuracion(flight.duracion()); }
            if(flight.capacidad() != 0) { oldFlight.setCapacidad(flight.capacidad()); }
            if(flight.aeropuertoDestino_id() != null) {  oldFlight.setAeropuertoDestino(aeropuertoMapper.toEntity(flight.aeropuertoDestino_id())); }
            if(flight.aeropuertoOrigen_id() != null) { oldFlight.setAeropuertoOrigen(aeropuertoMapper.toEntity(flight.aeropuertoOrigen_id())); }
            if(flight.fecha_salida() != null) {  oldFlight.setFecha_salida(flight.fecha_salida()); }
            if(flight.precio() != null) { oldFlight.setPrecio(flight.precio()); }

            return vueloMapper.toIdDto(vueloRepository.save(oldFlight));
        });
    }

    @Override
    public List<VueloDTO> findAll() {
        return vueloMapper.toListIdDto(vueloRepository.findAll());//aqui posiblemente el error(MAPPERVUELO)
    }

    @Override
    public List<VueloDTO> findByDate(LocalDate date) {//OJITO, no se esta usando, por ahora
        Vuelo f = new Vuelo();
        f.setFecha_salida(date);
        Example<Vuelo> example = Example.of(f);
        return vueloMapper.toListIdDto(vueloRepository.findAll(example));//AQUI POSIBLE ERROR(MAPPERVUELO)
    }

    @Override
    public void deleteById(Long id) {
        vueloRepository.deleteById(id);
    }


    public List<Vuelo> obtenerVuelosPorIds(List<Long> ids) {
        return vueloRepository.findByIdIn(ids);
    }
}
