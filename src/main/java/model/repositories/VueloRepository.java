package repositories;

import models.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    List<Vuelo> findByDestino(String destino);
    List<Vuelo> findByFechaDeSalida(Date fechaSalida);
    List<Vuelo> findByOrigen(String origen);
}
