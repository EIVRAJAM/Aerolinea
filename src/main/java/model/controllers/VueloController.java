package model.controllers;

import lombok.AllArgsConstructor;
import model.dto.VueloDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import model.services.VueloServices;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vuelos")
@AllArgsConstructor
public class VueloController {
    private final VueloServices vueloServices;
    @GetMapping()
    public ResponseEntity<List<VueloDTO>> getFlights() {
        return ResponseEntity.ok(vueloServices.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<VueloDTO> getFlightById(@PathVariable int id) {
        return vueloServices.findById(id)
                .map(f->ResponseEntity.ok().body(f))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping()
    public ResponseEntity<VueloDTO> createFlight(@RequestBody VueloDTO flight) {
        return createNewFlight(flight);
    }
    @PutMapping("/{id}")
    public ResponseEntity<VueloDTO> updateFlight(@PathVariable int id, @RequestBody VueloDTO flight) {
        Optional<VueloDTO> flightUpdate = vueloServices.update(id, flight);
        return flightUpdate
                .map(ResponseEntity::ok)
                .orElseGet(()-> createNewFlight(flight));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<VueloDTO> deleteFlight(@PathVariable int id) {
        vueloServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    private ResponseEntity<VueloDTO> createNewFlight(VueloDTO flight) {
        VueloDTO flightIdDto = vueloServices.save(flight);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(flightIdDto.id())
                .toUri();
        return ResponseEntity.created(location).body(flightIdDto);
    }

}

