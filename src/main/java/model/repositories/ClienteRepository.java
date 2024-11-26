package model.repositories;

import model.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNombre(String nombre);

    Optional<Cliente> findById(Long id);


    ///peligro
    @Query("SELECT u FROM Cliente u JOIN FETCH u.roles WHERE u.username = :username")
    Optional<Cliente> findByUsername(@Param("username") String username);
    Optional<Cliente> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
