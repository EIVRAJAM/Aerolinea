package model.services;

import aj.org.objectweb.asm.commons.Remapper;
import model.dto.VueloDTO;
import model.models.Vuelo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VueloServices {

    VueloDTO save(VueloDTO flight);
    Optional<VueloDTO> findById(int id);
    Optional<VueloDTO> update(int id, VueloDTO flight);
    List<VueloDTO> findAll();
    List<VueloDTO> findByDate(LocalDate date);
    void deleteById(int id);
}
