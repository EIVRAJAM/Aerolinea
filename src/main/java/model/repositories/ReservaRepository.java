package model.repositories;

import model.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByClienteId(Long id_cliente);

    @Override
    List<Reserva> findAllById(Iterable<Long> ids);
}
