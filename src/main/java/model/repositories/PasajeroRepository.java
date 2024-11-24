package model.repositories;

import model.models.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {
}
