package model.controllers;

import lombok.AllArgsConstructor;
import model.dto.PasajeroDTO;
import model.dto.ReservaDTO;
import model.mappers.PasajeroMapper;
import model.models.Pasajero;
import model.models.Reserva;
import model.repositories.PasajeroRepository;
import model.services.ClienteServices;
import model.services.PasajeroServices;
import model.services.VueloServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import model.services.ReservaServices;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reservas")
@AllArgsConstructor
public class ReservaController {
    private final ReservaServices reservaServices;
    private final ClienteServices clienteServices;
    private final VueloServices vueloServices;
    private final PasajeroMapper pasajeroMapper;
    private final PasajeroServices pasajeroServices;
    private final PasajeroRepository pasajeroRepository;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> getReserves() {
        return ResponseEntity.ok(reservaServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> getReserveById(@PathVariable("id") Long id) {
        return reservaServices.findById(id)
                .map(r->ResponseEntity.ok().body(r))
                .orElse(ResponseEntity.notFound().build());
    }

    //Obtiene reservas del cliente por si ID
    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<ReservaDTO>> getReserveByIdCliente(@PathVariable("id") Long id) {
        List<ReservaDTO> reservas = clienteServices.getReservasByCliente(id);

        if (reservas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reservas);
    }


    //Realizar una reserva
    @PostMapping()
    public ResponseEntity<ReservaDTO> createReserve(@RequestBody ReservaDTO reserve) {
        return createNewReserve(reserve);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> updateReserve(@PathVariable Long id, @RequestBody ReservaDTO reserve) {
        Optional<ReservaDTO> reserveUpdate = reservaServices.update(id,reserve);
        return reserveUpdate
                .map(ResponseEntity::ok)
                .orElseGet(()->createNewReserve(reserve));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        reservaServices.deleteById(id); // Llama al método del servicio para eliminar
        return ResponseEntity.noContent().build(); // Responde 204
    }

    private ResponseEntity<ReservaDTO> createNewReserve(ReservaDTO reserve) {
        ReservaDTO reserveIdDto = reservaServices.save(reserve);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reserveIdDto.id())
                .toUri();
        return ResponseEntity.created(location).body(reserveIdDto);
    }
}
