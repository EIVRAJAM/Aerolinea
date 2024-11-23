package model.services;

import lombok.AllArgsConstructor;
import model.dto.ClienteDTO;
import model.mappers.ClienteMapper;
import model.mappers.ReservaMapper;
import model.models.Cliente;
import model.repositories.ClienteRepository;
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

    @Override
    public ClienteDTO save(ClienteDTO client) {
        return clienteMapper.toIdDto(clienteRepository.save(clienteMapper.toEntity(client)));
    }

    @Override
    public Optional<ClienteDTO> findById(int id) {
        return clienteRepository.findById(id).map(clienteMapper::toIdDto);
    }

    @Override
    public Optional<ClienteDTO> update(int id, ClienteDTO client) {
        return clienteRepository.findById(id).map(oldClient -> {
            oldClient.setDireccion(client.direccion());
            oldClient.setNombre(client.nombre());
            oldClient.setApellidos(client.apellidos());
            oldClient.setEmail(client.email());
            oldClient.setTelefono(client.telefono());
            oldClient.setReservas(reservaMapper.toListEntity(client.reservas()));
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
    public void deleteById(int id) {
        clienteRepository.deleteById(id);
    }
}
