package model.services;

import lombok.AllArgsConstructor;
import model.dto.PasajeroDTO;
import model.mappers.PasajeroMapper;
import model.mappers.ReservaMapper;
import model.repositories.PasajeroRepository;
import model.models.Pasajero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class PasajeroServicesImpl implements PasajeroServices {
    private final PasajeroMapper pasajeroMapper;
    private final ReservaMapper reservaMapper;
    private final PasajeroRepository pasajeroRepository;

    @Override
    public PasajeroDTO save(PasajeroDTO passenger) {
        return pasajeroMapper.toIdDto(pasajeroRepository.save(pasajeroMapper.toEntity(passenger)));
    }

    @Override
    public Optional<PasajeroDTO> getById(Long id) {
        return pasajeroRepository.findById(id).map(pasajeroMapper::toIdDto);
    }

    @Override
    public Optional<PasajeroDTO> update(Long id, PasajeroDTO passenger) {  // Cambiar int a Long
        return pasajeroRepository.findById(id).map(oldPassenger -> {
        if(passenger.nombre() != null) { oldPassenger.setNombre(passenger.nombre()); }
        if(passenger.apellido() != null) { oldPassenger.setApellido(passenger.apellido()); }
        if(passenger.direccion() != null) { oldPassenger.setDireccion(passenger.direccion()); }
        if(passenger.telefono() != null) { oldPassenger.setTelefono(passenger.telefono()); }
        if(passenger.email() != null) { oldPassenger.setEmail(passenger.email()); }
        if(passenger.reserva_id() != null) { oldPassenger.setReserva(reservaMapper.toEntity(passenger.reserva_id())); }

        return pasajeroMapper.toIdDto(pasajeroRepository.save(oldPassenger));
        });
    }


    /*
    @Override
    public Optional<PasajeroDTO> update(int id, PasajeroDTO passenger) {
        return pasajeroRepository.findById(id).map(oldPassenger ->{
            oldPassenger.setNombre(passenger.nombre());
            oldPassenger.setApellido(passenger.apellido());
            oldPassenger.setDireccion(passenger.direccion());
            oldPassenger.setTelefono(passenger.telefono());
            oldPassenger.setEmail(passenger.email());
            oldPassenger.setReserva(reservaMapper.toEntity(passenger.reserva()));
            return pasajeroMapper.toIdDto(pasajeroRepository.save(oldPassenger));
        });
    }
    */

    @Override
    public List<PasajeroDTO> findAll() {
        return pasajeroMapper.toListIdDto(pasajeroRepository.findAll());
    }

    @Override
    public List<PasajeroDTO> findByName(String name) {
        Pasajero p = new Pasajero();
        p.setNombre(name);
        Example<Pasajero> example = Example.of(p);
        return pasajeroMapper.toListIdDto(pasajeroRepository.findAll(example));
    }

    @Override
    public void deleteById(Long id) {
        pasajeroRepository.deleteById(id);
    }
}
