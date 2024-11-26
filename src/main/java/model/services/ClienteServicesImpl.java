package model.services;

import lombok.AllArgsConstructor;
import model.dto.ClienteDTO;
import model.dto.ReservaDTO;
import model.mappers.ClienteMapper;
import model.mappers.ReservaMapper;
import model.models.Cliente;
import model.models.Reserva;
import model.repositories.ClienteRepository;
import model.repositories.ReservaRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class ClienteServicesImpl implements ClienteServices {
    private final ClienteMapper clienteMapper;
    private final ReservaMapper reservaMapper;
    private ClienteRepository clienteRepository;
    private final ReservaRepository reservaRepository;

    @Override
    public ClienteDTO save(ClienteDTO client) {
        return clienteMapper.toIdDto(clienteRepository.save(clienteMapper.toEntity(client)));
    }

    @Override
    public Optional<ClienteDTO> findById(Long id) {
        return clienteRepository.findById(id).map(clienteMapper::toIdDto);
    }

    @Override
    public Optional<ClienteDTO> update(Long id, ClienteDTO client) {
        return clienteRepository.findById(id).map(oldClient -> {
            if(client.direccion() != null) { oldClient.setDireccion(client.direccion()); }
            if(client.nombre() != null) { oldClient.setNombre(client.nombre()); }
            if(client.apellidos() != null) { oldClient.setApellidos(client.apellidos()); }
            if(client.email() != null) { oldClient.setEmail(client.email()); }
            if(client.telefono() != null) { oldClient.setTelefono(client.telefono()); }
            if(client.reservas() != null) { oldClient.setReservas(reservaMapper.toListEntity(client.reservas())); }

            return clienteMapper.toIdDto(clienteRepository.save(oldClient));
        });
    }

    @Override
    public List<ClienteDTO> findAll() {
        return clienteMapper.toListIdDto(clienteRepository.findAll());
    }

    @Override
    public List<ClienteDTO> findByName(String name) {
        Cliente c = new Cliente();
        c.setNombre (name);
        Example<Cliente> example = Example.of(c);
        return clienteMapper.toListIdDto(clienteRepository.findAll(example));
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ReservaDTO> getReservasByCliente(Long clienteId) {
        // Obtener el cliente_id por su ID
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Obtener las reservas del cliente_id
        List<Reserva> reservas = reservaRepository.findByClienteId(clienteId);

        // Convertir las reservas a DTOs (si estás usando DTOs)
        return reservaMapper.toListDto(reservas);
    }

    //Se añadio
    public ClienteDTO findByUsername(String username) {
        return clienteRepository.findByUsername(username)
                .map(cliente -> clienteMapper.toDto(cliente))
                .orElse(null);
    }
}
