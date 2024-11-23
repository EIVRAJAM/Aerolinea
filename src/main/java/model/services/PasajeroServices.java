package model.services;

import model.dto.PasajeroDTO;
import model.models.Pasajero;

import java.util.List;
import java.util.Optional;

public interface PasajeroServices {
    PasajeroDTO save(PasajeroDTO passenger);
    Optional<PasajeroDTO> getById(int id);
    Optional<PasajeroDTO> update(int id, PasajeroDTO passenger);
    List<PasajeroDTO> findAll();
    List<PasajeroDTO> findByName(String name);
    void deleteById(int id);
}
