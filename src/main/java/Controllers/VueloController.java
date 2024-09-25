package Controllers;

import com.example.aerolineamodels.models.Reserva;
import com.example.aerolineamodels.models.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import services.VueloServices;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vuelos")
public class VueloController {

    @Autowired
    private VueloServices vueloServices;

    @GetMapping
    public ResponseEntity<List<Vuelo>> obtenerTodos() {
        return ResponseEntity.ok(vueloServices.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerPorId(@PathVariable Long id) {
        Optional<Vuelo> vuelo = vueloServices.obtenerPorId(id);
        return vuelo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vuelo> guardar(@RequestBody Vuelo vuelo) {
        return ResponseEntity.ok(vueloServices.guardar(vuelo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        vueloServices.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<Vuelo>> buscarPorOrigen(@RequestParam(required = false, value = "origen") String origen) {
        return ResponseEntity.ok(vueloServices.buscarPorOrigen(origen));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizarVuelo(@PathVariable Long id, @RequestBody Vuelo vuelo) {
        try {
            Vuelo vueloActualizado = vueloServices.actualizarVuelo(id, vuelo);
            return ResponseEntity.ok(vueloActualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    private static ResponseEntity<Vuelo> createNewVuelo(Vuelo vuelo) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vuelo.getId_vuelo())
                .toUri();

        return ResponseEntity.created(location).body(vuelo);
    }
}
