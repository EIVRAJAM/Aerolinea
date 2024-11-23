package controllers;

import models.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import services.ReservaServices;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaController {

    @Autowired
    private ReservaServices reservaServices;

    @GetMapping
    public ResponseEntity<List<Reserva>> obtenerTodas() {
        return ResponseEntity.ok(reservaServices.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerPorId(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaServices.obtenerPorId(id);
        return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> guardar(@RequestBody Reserva reserva) {
        return createNewReserva(reserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        reservaServices.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Reserva>> buscarPorCliente(@RequestParam Long idCliente) {
        return ResponseEntity.ok(reservaServices.buscarPorCliente(idCliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        try {
            Reserva reservaActualizada = reservaServices.actualizarReserva(id, reserva);
            return ResponseEntity.ok(reservaActualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    private static ResponseEntity<Reserva> createNewReserva(Reserva reserva) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reserva.getId_reserva())
                .toUri();

        return ResponseEntity.created(location).body(reserva);
    }
}
