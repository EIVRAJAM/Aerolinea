package Repositories;

import com.example.aerolineamodels.models.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {
    List<Aerolinea> findByNombre(String nombre);
    List<Aerolinea> findByPaisOrigen(String pais);
}
