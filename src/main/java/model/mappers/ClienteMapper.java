package model.mappers;

import model.dto.ClienteDTO;
import model.models.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = ReservaMapper.class)
public interface ClienteMapper {

    @Named("complete")
    @Mapping(source = "cliente.reservas", target = "reservas", qualifiedByName = "listCompleteWithoutEntities")
    ClienteDTO toIdDto(Cliente cliente);//...ok

    @Named("listComplete")
    @Mapping(source = "clientes.reservas", target = "reservas", qualifiedByName = "listCompleteWithoutEntities")
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

    @Named("clienteCompleteWithoutReserve")
    @Mapping(target = "reservas", ignore = true)
    ClienteDTO toIdDtoWithoutReserve(Cliente cliente);//...ok

    @Named("clientesListCompleteWithoutReserve")
    @Mapping(target = "reservas", ignore = true)
    List<ClienteDTO> toListIdDtoWithoutReserve(List<Cliente> clientes);//...ok

    @Named("clienteEntityWithoutReserve")
    @Mapping(target = "reservas", ignore = true)
    Cliente toEntityWithoutReserve(Cliente cliente);//...ok

    @Named("clientesListEntityWithoutReserve")
    @Mapping(target = "reservas", ignore = true)
    List<Cliente> toListEntityWithoutReserve(List<Cliente> clientes);//...ok

    @Named("clienteWithoutIdWithoutReserve")
    @Mapping(target = "reservas", ignore = true)
    @Mapping(target = "id", ignore = true)
    ClienteDTO toDtoWithoutReserve(Cliente cliente);//

    @Named("clientesListWithoutIdWithoutReserve")
    @Mapping(target = "reservas", ignore = true)
    @Mapping(target = "id", ignore = true)
    List<ClienteDTO> toListDtoWithoutReserve(List<Cliente> clientes);

    @Named("clienteWithoutReservas")
    @Mapping(target = "reservas", ignore = true)
    ClienteDTO clienteToClienteDTOWithoutReservas(Cliente cliente);

    @Mapping(target = "id", source = "id")
    Cliente toEntity(Long id);
}