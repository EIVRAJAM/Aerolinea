package model.repositories;
import model.models.ERol;
import model.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;
import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
