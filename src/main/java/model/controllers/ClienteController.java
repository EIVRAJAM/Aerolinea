package model.controllers;

import lombok.AllArgsConstructor;
import model.dto.ClienteDTO;
import model.dto.ReservaDTO;
import model.services.ClienteServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clientes")
@AllArgsConstructor
public class ClienteController {
    private final ClienteServices clienteServices;


    @GetMapping()
    public ResponseEntity<List<ClienteDTO>> getClients() {
        return ResponseEntity.ok(clienteServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClientById(@PathVariable int id) {
        return clienteServices.findById(id)
                .map( c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<ClienteDTO> createClient(@RequestBody ClienteDTO client) {
        return createNewClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateClient(@PathVariable int id, @RequestBody ClienteDTO client) {
        Optional<ClienteDTO> clientUpdated = clienteServices.update(id, client);
        return clientUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> createNewClient(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable int id) {
        clienteServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<ClienteDTO> createNewClient(ClienteDTO client) {
        ClienteDTO clientIdDto = clienteServices.save(client);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientIdDto.id())
                .toUri();
        return ResponseEntity.created(location).body(clientIdDto);
    }

    @GetMapping("/{id}/reservas")
    public ResponseEntity<List<ReservaDTO>> getReservasByCliente(@PathVariable Long id) {
        List<ReservaDTO> reservas = clienteServices.getReservasByCliente(id);
        return ResponseEntity.ok(reservas);
    }

}
