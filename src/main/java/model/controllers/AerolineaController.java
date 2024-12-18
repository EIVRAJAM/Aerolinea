package model.controllers;

import lombok.AllArgsConstructor;
import model.dto.AerolineaDTO;
import model.services.AerolineaServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/aerolineas")
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000")
public class AerolineaController {
    private final AerolineaServices aerolineaServices;

    @GetMapping
    public ResponseEntity<List<AerolineaDTO>> getAirlines() {
        return ResponseEntity.ok(aerolineaServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AerolineaDTO> getAirlineById(@PathVariable("id") Long id) {
        return aerolineaServices.findById(id)
                .map( a-> ResponseEntity.ok().body(a))
                .orElse(ResponseEntity.notFound().build());
    }

    //Busca el id de una aerolinea por su nombre
    @GetMapping("/aerolineas/id/{nombre}")
    public ResponseEntity<Long> obtenerIdPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok().body(aerolineaServices.buscarIdPorNombre(nombre));
    }

    @PostMapping()
    public ResponseEntity<AerolineaDTO> createAirline(@RequestBody AerolineaDTO airline) {
        return createNewAirline(airline);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AerolineaDTO> updateAirline(@PathVariable Long id, @RequestBody AerolineaDTO airline){
        Optional<AerolineaDTO> airlineUpdated = aerolineaServices.update(id, airline);
        return airlineUpdated.map(ResponseEntity::ok).orElseGet(() -> createNewAirline(airline));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AerolineaDTO> deleteAirline(@PathVariable Long id) {
        aerolineaServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    private ResponseEntity<AerolineaDTO> createNewAirline(AerolineaDTO airline) {
        AerolineaDTO airlineIdDto = aerolineaServices.save(airline);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(airlineIdDto.id())
                .toUri();
        return ResponseEntity.created(location).body(airlineIdDto);
    }
}
