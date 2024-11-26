package model.repositories;

import model.models.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    List<Vuelo> findByIdIn(List<Long> ids);
}
