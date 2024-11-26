package model.services;

import model.dto.ClienteDTO;
import model.dto.ReservaDTO;
import model.models.Reserva;
import model.models.Vuelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservaServices {
    ReservaDTO save(ReservaDTO reserve);
    Optional<ReservaDTO> findById(Long id);
    Optional<ReservaDTO> update(Long id, ReservaDTO reserve);
    List<ReservaDTO> findAll();
    List<ReservaDTO> findByClient(ClienteDTO client);
    List<ReservaDTO> findByDate(LocalDate date);
    void deleteById(Long id);

    List<Reserva> findAllById(List<Long> ids);

    List<Vuelo> findFlightsByReservationId(Long reservationId);

}

