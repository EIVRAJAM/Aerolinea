package model.services;

import model.dto.AeropuertoDTO;
import model.models.Aeropuerto;

import java.util.List;
import java.util.Optional;

public interface AeropuertoServices {
    AeropuertoDTO save(AeropuertoDTO airport);
    Optional<AeropuertoDTO> findById(int id);
    Optional<AeropuertoDTO> update(int id, AeropuertoDTO airport);
    List<AeropuertoDTO> findAll();
    List<AeropuertoDTO> findByName(String name);
    void deleteById(int id);
}
