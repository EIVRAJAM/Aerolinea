package model.mappers;

import model.dto.ClienteDTO;
import model.models.Cliente;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = ReservaMapper.class)
public interface ClienteMapper {

    @Named("clienteComplete")
    @Mapping(source = "cliente.reservas", target = "reservas", qualifiedByName = "listReservasComplete")
    ClienteDTO toIdDto(Cliente cliente);//...ok

    @Named("listComplete")
    @IterableMapping(qualifiedByName = "clienteComplete")
    List<ClienteDTO> toListIdDto(List<Cliente> clientes);//...ok

    @Mapping(source = "clienteDTO.reservas", target = "reservas", qualifiedByName = "listEntityWithoutDtos")
    Cliente toEntity(ClienteDTO clienteDTO);//...ok

    @Mapping(source = "clientesDTO.reservas", target = "reservas", qualifiedByName = "listEntityWithoutDtos")
    List<Cliente> toListEntity(List<ClienteDTO> clientesDTO);//...ok

    @Named("clienteWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "cliente.reservas", target = "reservas", qualifiedByName = "listWithoutIdWithoutEntities")
    ClienteDTO toDto(Cliente cliente);//...ok

    @Named("clientesListWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "clientes.reservas", target = "reservas", qualifiedByName = "listWithoutIdWithoutEntities")
    List<ClienteDTO> toListDto(List<Cliente> clientes);//...ok

    @Mapping(target = "id", source = "id")
    Cliente toEntity(Long id);
}