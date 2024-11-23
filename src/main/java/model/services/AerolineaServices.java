package model.services;

import model.dto.AerolineaDTO;

import java.util.List;
import java.util.Optional;

public interface AerolineaServices {
    AerolineaDTO save(AerolineaDTO airline);
    Optional<AerolineaDTO > findById(int id);
    Optional<AerolineaDTO > update(int id, AerolineaDTO  airline);
    List<AerolineaDTO > findAll();
    List<AerolineaDTO > findByName(String name);
    void deleteById(int id);
}
