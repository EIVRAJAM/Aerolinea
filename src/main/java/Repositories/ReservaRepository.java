package Repositories;

import com.example.aerolineamodels.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByNumeroPasajeros(int numero);
    List<Reserva> findByCliente_Id(Long idCliente);

    List<Reserva> findByClienteId(Long idCliente);
}
