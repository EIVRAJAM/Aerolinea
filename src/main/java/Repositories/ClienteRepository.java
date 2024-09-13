package Repositories;

import com.example.aerolineamodels.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNombre(String nombre);
    List<Cliente> findByEmail(String email);
}
