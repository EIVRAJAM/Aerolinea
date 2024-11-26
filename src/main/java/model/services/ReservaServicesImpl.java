package model.services;

import lombok.AllArgsConstructor;
import model.dto.ClienteDTO;
import model.dto.ReservaDTO;
import model.mappers.ClienteMapper;
import model.mappers.PasajeroMapper;
import model.mappers.ReservaMapper;
import model.mappers.VueloMapper;
import model.models.Vuelo;
import model.repositories.ReservaRepository;
import model.models.Reserva;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class ReservaServicesImpl implements ReservaServices {
    private final ReservaMapper reservaMapper;
    private final ClienteMapper clienteMapper;
    private final VueloServices vueloServices;
    private final PasajeroMapper pasajeroMapper;
    ReservaRepository reservaRepository;

    @Override
    public ReservaDTO save(ReservaDTO reserve) {
        Reserva reserva = reservaMapper.toEntity(reserve);

        reserva.setVuelos(vueloServices.obtenerVuelosPorIds(reserve.vuelos_ids()));

        return reservaMapper.toIdDto(reservaRepository.save(reserva));
    }

    @Override
    public Optional<ReservaDTO> findById(Long id) {
        return reservaRepository.findById(id).map(reservaMapper::toIdDto);//ojoconesammada
    }

    @Override
    public Optional<ReservaDTO> update(Long id, ReservaDTO reserve) {
        return reservaRepository.findById(id).map(oldReserve -> {
            if(reserve.cliente_id() != null) { oldReserve.setCliente(clienteMapper.toEntity(reserve.cliente_id())); }
            if(reserve.fecha() != null) { oldReserve.setFecha(reserve.fecha()); }
            if(reserve.vuelos_ids() != null) { oldReserve.setVuelos( findFlightsByReservationId(id)); }
            if(reserve.pasajeros() != null) { oldReserve.setPasajeros(pasajeroMapper.toListEntity(reserve.pasajeros())); }
            if(reserve.numeroPasajeros() != 0) { oldReserve.setNumeroPasajeros(reserve.numeroPasajeros()); }

            return reservaMapper.toIdDto(reservaRepository.save(oldReserve));
        });
    }

    @Override
    public List<ReservaDTO> findAll() {
        return reservaMapper.toListIdDto(reservaRepository.findAll());
    }


    @Override
    public List<ReservaDTO> findByClient(ClienteDTO client) {
        Reserva r = new Reserva();
        r.setCliente(clienteMapper.toEntity(client));
        Example<Reserva> example = Example.of(r);
        return reservaMapper.toListIdDto(reservaRepository.findAll(example));
    }

    @Override
    public List<ReservaDTO> findByDate(LocalDate date) {
        Reserva r = new Reserva();
        r.setFecha(date);
        Example<Reserva> example = Example.of(r);
        return reservaMapper.toListIdDto(reservaRepository.findAll(example));
    }

    @Override
    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }

    public List<Reserva> findAllById(List<Long> ids) {
        return null;
    }

    @Override
    public List<Vuelo> findFlightsByReservationId(Long reservationId) {
        Optional<Reserva> reserva = reservaRepository.findById(reservationId); // Asumiendo que tienes un repositorio
        if (reserva.isPresent()) {
            return reserva.get().getVuelos(); // Devuelve la lista de vuelos
        } else {
            throw new IllegalArgumentException("Reserva no encontrada con el ID: " + reservationId);
        }
    }


}