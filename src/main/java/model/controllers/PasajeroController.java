package model.controllers;

import lombok.AllArgsConstructor;
import model.dto.PasajeroDTO;
import model.models.Pasajero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import model.services.PasajeroServices;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pasajeros")
@AllArgsConstructor
public class PasajeroController {
    private final PasajeroServices passengerService;
    @GetMapping()
    public ResponseEntity<List<PasajeroDTO>> getPassengers() {
        return ResponseEntity.ok(passengerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PasajeroDTO> getPassengerById(@PathVariable("id") int id) {
        return passengerService.getById(id)
                .map(p->ResponseEntity.ok().body(p))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping()
    public ResponseEntity<PasajeroDTO> createPassenger(@RequestBody PasajeroDTO passenger) {
        return createNewPassenger(passenger);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PasajeroDTO> updatePassenger(@PathVariable("id") int id,@RequestBody PasajeroDTO passenger) {
        Optional<PasajeroDTO> passengerUpdated = passengerService.update(id, passenger);
        return passengerUpdated
                .map(ResponseEntity::ok)
                .orElseGet(()->createNewPassenger(passenger));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<PasajeroDTO> deletePassenger(@PathVariable("id") int id) {
        passengerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    private ResponseEntity<PasajeroDTO> createNewPassenger(PasajeroDTO passenger) {
        PasajeroDTO passengerIdDto = passengerService.save(passenger);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(passengerIdDto.id())
                .toUri();
        return ResponseEntity.created(location).body(passengerIdDto);
    }
}
