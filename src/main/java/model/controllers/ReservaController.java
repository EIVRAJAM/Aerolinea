package model.controllers;

import lombok.AllArgsConstructor;
import model.dto.ReservaDTO;
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
