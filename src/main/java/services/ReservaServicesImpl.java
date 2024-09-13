package services;

import Repositories.ReservaRepository;
import com.example.aerolineamodels.models.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServicesImpl implements services.ReservaServices {

    @Autowired
    private ReservaRepository reservaRepositorio;

    @Override
    public List<Reserva> obtenerTodas() {
        return reservaRepositorio.findAll();
    }

    @Override
    public Optional<Reserva> obtenerPorId(Long id) {
        return reservaRepositorio.findById(id);
    }

    @Override
    public Reserva guardar(Reserva reserva) {
        return reservaRepositorio.save(reserva);
    }

    @Override
    public void eliminarPorId(Long id) {
        reservaRepositorio.deleteById(id);
    }

    @Override
    public List<Reserva> buscarPorCliente(Long idCliente) {
        return reservaRepositorio.findByClienteId(idCliente);
    }

    @Override
    public Reserva actualizarReserva(Long id, Reserva reserva) {
        Reserva reservaExistente = reservaRepositorio.findById(id).orElseThrow();
        reservaExistente.setFechaReserva(reserva.getFechaReserva());
        reservaExistente.setNumeroPasajeros(reserva.getNumeroPasajeros());
        return reservaRepositorio.save(reservaExistente);
    }
}
