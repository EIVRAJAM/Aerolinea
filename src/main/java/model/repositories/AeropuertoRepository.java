package repositories;

import models.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
    List<Aeropuerto> findByCiudad(String ciudad);
    List<Aeropuerto> findByPais(String pais);
    List<Aeropuerto> findByNombre(String nombre);
}
