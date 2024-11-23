package controllers;

import models.Aeropuerto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import services.AeropuertoServices;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/aeropuertos")
public class AeropuertoController {

    @Autowired
    private AeropuertoServices aeropuertoServices;

    @GetMapping
    public ResponseEntity<List<Aeropuerto>> obtenerTodos() {
        return ResponseEntity.ok(aeropuertoServices.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aeropuerto> obtenerPorId(@PathVariable Long id) {
        Optional<Aeropuerto> aeropuerto = aeropuertoServices.obtenerPorId(id);
        return aeropuerto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aeropuerto> guardar(@RequestBody Aeropuerto aeropuerto) {
        return createNewAerpuerto(aeropuerto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        aeropuertoServices.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<Aeropuerto>> buscarPorNombre(@RequestParam(required = false, value = "nombre") String nombre) {
        return ResponseEntity.ok(aeropuertoServices.buscarPorNombre(nombre));
    }

    @GetMapping()
    public ResponseEntity<List<Aeropuerto>> buscarPorCiudad(@RequestParam(required = false, value = "ciudad") String ciudad) {
        return ResponseEntity.ok(aeropuertoServices.buscarPorCiudad(ciudad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aeropuerto> actualizarAeropuerto(@PathVariable Long id, @RequestBody Aeropuerto aeropuerto) {
        try {
            Aeropuerto aeropuertoActualizado = aeropuertoServices.actualizarAeropuerto(id, aeropuerto);
            return ResponseEntity.ok(aeropuertoActualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    private static ResponseEntity<Aeropuerto> createNewAerpuerto(Aeropuerto aeropuerto) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(aeropuerto.getId_aeropuerto())
                .toUri();
        return ResponseEntity.created(location).body(aeropuerto);
    }
}
