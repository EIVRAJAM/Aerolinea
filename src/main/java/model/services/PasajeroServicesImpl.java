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
    public Optional<PasajeroDTO> getById(int id) {
        return pasajeroRepository.findById(id).map(pasajeroMapper::toIdDto);
    }

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
    public void deleteById(int id) {
        pasajeroRepository.deleteById(id);
    }
}
