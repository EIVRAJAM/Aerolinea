package model.repositories;

import model.models.ERol;
import model.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByRole(ERol role);
}
