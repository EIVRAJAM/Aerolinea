package services;

import Repositories.ClienteRepository;
import com.example.aerolineamodels.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicesImpl implements services.ClienteServices {

    @Autowired
    private ClienteRepository clienteRepositorio;

    @Override
    public List<Cliente> obtenerTodos() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Optional<Cliente> obtenerPorId(Long id) {
        return clienteRepositorio.findById(id);
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarPorId(Long id) {
        clienteRepositorio.deleteById(id);
    }

    @Override
    public List<Cliente> buscarPorNombre(String nombre) {
        return clienteRepositorio.findByNombre(nombre);
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente cliente) {
        Cliente clienteExistente = clienteRepositorio.findById(id).orElseThrow();
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellidos(cliente.getApellidos());
        return clienteRepositorio.save(clienteExistente);
    }
}
