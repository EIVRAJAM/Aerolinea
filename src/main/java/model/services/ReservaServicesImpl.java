package model.services;

import lombok.AllArgsConstructor;
import model.dto.ClienteDTO;
import model.dto.ReservaDTO;
import model.mappers.ClienteMapper;
import model.mappers.PasajeroMapper;
import model.mappers.ReservaMapper;
import model.mappers.VueloMapper;
import model.repositories.ReservaRepository;
import model.models.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class ReservaServicesImpl implements ReservaServices {
    private final ReservaMapper reservaMapper;
    private final ClienteMapper clienteMapper;
    private final VueloMapper vueloMapper;
    private final PasajeroMapper pasajeroMapper;
    ReservaRepository reservaRepository;

    @Override
    public ReservaDTO save(ReservaDTO reserve) {
        return reservaMapper.toIdDto(reservaRepository.save(reservaMapper.toEntity(reserve)));
    }

    @Override
    public Optional<ReservaDTO> findById(int id) {
        return reservaRepository.findById(id).map(reservaMapper::toDto);
    }

    @Override
    public Optional<ReservaDTO> update(int id, ReservaDTO reserve) {
        return reservaRepository.findById(id).map(oldReserve -> {
            oldReserve.setCliente(clienteMapper.toEntity(reserve.cliente()));
            oldReserve.setFecha(reserve.fecha());
            oldReserve.setVuelos(vueloMapper.toListEntity(reserve.vuelos()));
            oldReserve.setPasajeros(pasajeroMapper.toListEntity(reserve.pasajeros()));
            oldReserve.setNumeroPasajeros(reserve.numeroPasajeros());
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
    public void deleteById(int id) {
        reservaRepository.deleteById(id);
    }


}
