package model.controllers;

import lombok.AllArgsConstructor;
import model.dto.AeropuertoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import model.services.AeropuertoServices;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/aeropuertos")
@AllArgsConstructor
public class AeropuertoController {
    private final AeropuertoServices aeropuertoServices;

    @GetMapping
    public ResponseEntity<List<AeropuertoDTO>> getAirports() {
        return ResponseEntity.ok(aeropuertoServices.findAll());
    }

    //BuscarAeropuerto por su id
    @GetMapping("/{id}")
    public ResponseEntity<AeropuertoDTO> getAirportById(@PathVariable("id") Long id) {
        return aeropuertoServices.findById(id)
                .map(a->ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build());
    }

    //Registrar Aeropuerto
    @PostMapping
    public ResponseEntity<AeropuertoDTO> createAirport(@RequestBody AeropuertoDTO airport) {
        return createNewAirport(airport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AeropuertoDTO> updateAirport(@PathVariable Long id, @RequestBody AeropuertoDTO airport) {
        Optional<AeropuertoDTO> airportUpdated = aeropuertoServices.update(id, airport);
        return airportUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> createNewAirport(airport));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AeropuertoDTO> deleteAirport(@PathVariable Long id) {
        aeropuertoServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<AeropuertoDTO> createNewAirport(AeropuertoDTO airport) {
        AeropuertoDTO airportIdDto = aeropuertoServices.save(airport);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(airportIdDto.id())
                .toUri();

        return ResponseEntity.created(location).body(airportIdDto);
    }


}
