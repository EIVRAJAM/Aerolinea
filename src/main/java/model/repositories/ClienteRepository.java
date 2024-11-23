package model.repositories;

import model.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNombre(String nombre);
    List<Cliente> findByEmail(String email);

    Optional<Cliente> findById(Long id);
}
