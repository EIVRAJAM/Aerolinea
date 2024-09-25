package Controllers;

import com.example.aerolineamodels.models.Aerolinea;
import com.example.aerolineamodels.models.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import services.AerolineaServices;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/aerolineas")
public class AerolineaController {

    @Autowired
    private AerolineaServices aerolineaServices;

    @GetMapping
    public ResponseEntity<List<Aerolinea>> obtenerTodas() {
        return ResponseEntity.ok(aerolineaServices.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aerolinea> obtenerPorId(@PathVariable Long id) {
        Optional<Aerolinea> aerolinea = aerolineaServices.obtenerPorId(id);
        return aerolinea.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aerolinea> guardar(@RequestBody Aerolinea aerolinea) {
        return createNewAerolinea(aerolinea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        aerolineaServices.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public  ResponseEntity<List<Aerolinea>> buscarPorNombre(@RequestParam(required = false, value = "nombre") String nombre) {
        return ResponseEntity.ok(aerolineaServices.buscarPorNombre(nombre));
    }

    @GetMapping()
    public ResponseEntity<List<Aerolinea>> buscarPorPais(@RequestParam(required = false, value = "pais") String pais) {
        return ResponseEntity.ok(aerolineaServices.buscarPorPais(pais));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aerolinea> actualizarAerolinea(@PathVariable Long id, @RequestBody Aerolinea aerolinea) {
        try {
            Aerolinea aerolineaActualizada = aerolineaServices.actualizarAerolinea(id, aerolinea);
            return ResponseEntity.ok(aerolineaActualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    private static ResponseEntity<Aerolinea> createNewAerolinea(Aerolinea aerolinea) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(aerolinea.getId_aerolinea())
                .toUri();

        return ResponseEntity.created(location).body(aerolinea);
    }
}
