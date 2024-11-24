package model.services;

import model.dto.ClienteDTO;
import model.dto.ReservaDTO;
import model.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteServices {
    ClienteDTO save(ClienteDTO client);
    Optional<ClienteDTO> findById(Long id);
    Optional<ClienteDTO> update(Long id, ClienteDTO client);
    List<ClienteDTO> findAll();
    List<ClienteDTO> findByName(String name);
    void deleteById(Long id);

    List<ReservaDTO> getReservasByCliente(Long clienteId);

    public ClienteDTO findByUsername(String username);
}
