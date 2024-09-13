package services;

import com.example.aerolineamodels.models.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaServices {

    List<Reserva> obtenerTodas();

    Optional<Reserva> obtenerPorId(Long id);

    Reserva guardar(Reserva reserva);

    void eliminarPorId(Long id);

    List<Reserva> buscarPorCliente(Long idCliente);

    Reserva actualizarReserva(Long id, Reserva reserva);
}
