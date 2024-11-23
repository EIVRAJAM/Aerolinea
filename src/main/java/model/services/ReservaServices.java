package model.services;

import model.dto.ClienteDTO;
import model.dto.ReservaDTO;
import model.models.Reserva;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservaServices {
    ReservaDTO save(ReservaDTO reserve);
    Optional<ReservaDTO> findById(int id);
    Optional<ReservaDTO> update(int id, ReservaDTO reserve);
    List<ReservaDTO> findAll();
    List<ReservaDTO> findByClient(ClienteDTO client);
    List<ReservaDTO> findByDate(LocalDate date);
    void deleteById(int id);
}

