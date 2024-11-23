package controllers;

import models.Pasajero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import services.PasajeroServices;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pasajeros")
public class PasajeroController {

    @Autowired
    private PasajeroServices pasajeroServices;

    @GetMapping
    public ResponseEntity<List<Pasajero>> obtenerTodos() {
        return ResponseEntity.ok(pasajeroServices.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pasajero> obtenerPorId(@PathVariable Long id) {
        Optional<Pasajero> pasajero = pasajeroServices.obtenerPorId(id);
        return pasajero.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pasajero> guardar(@RequestBody Pasajero pasajero) {
        return createNewPasajero(pasajero);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        pasajeroServices.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<Pasajero>> buscarPorNombre(@RequestParam(required = false, value = "nombre") String nombre) {
        return ResponseEntity.ok(pasajeroServices.buscarPorNombre(nombre));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pasajero> actualizarPasajero(@PathVariable Long id, @RequestBody Pasajero pasajero) {
        try {
            Pasajero pasajeroActualizado = pasajeroServices.actualizarPasajero(id, pasajero);
            return ResponseEntity.ok(pasajeroActualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    private static ResponseEntity<Pasajero> createNewPasajero(Pasajero pasajero) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pasajero.getId_pasajero())
                .toUri();
        return ResponseEntity.created(location).body(pasajero);
    }
}
