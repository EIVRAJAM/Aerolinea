package model.repositories;

import model.models.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
}
