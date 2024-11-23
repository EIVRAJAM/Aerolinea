package repositories;

import models.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {
    List<Pasajero> findByCedula(int cedula);
    List<Pasajero> findByNombre(String nombre);
}
