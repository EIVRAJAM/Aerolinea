package services;

import com.example.aerolineamodels.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteServices {

    List<Cliente> obtenerTodos();

    Optional<Cliente> obtenerPorId(Long id);

    Cliente guardar(Cliente cliente);

    void eliminarPorId(Long id);

    List<Cliente> buscarPorNombre(String nombre);

    Cliente actualizarCliente(Long id, Cliente cliente);
}
