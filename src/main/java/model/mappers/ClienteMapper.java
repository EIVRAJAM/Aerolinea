package mappers;

import dto.ClienteDTO;
import models.Cliente;
import org.mapstruct.Named;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    @Named("complete")
    ClienteDTO toIdDto(Cliente cliente);
    @Named("listComplete")
    ArrayList<ClienteDTO> toListIdDto( ArrayList<Cliente> clientes);
    Cliente toEntity(ClienteDTO clientDto);
    ArrayList<Cliente> toListEntity(ArrayList<ClienteDTO> clienteDTOS);
    @Named("withoutId")
    @Mapping(target = "id_cliente",ignore = true)
    ClienteDTO toDto(Cliente cliente);
    @Named("listWithoutId")
    @Mapping(target = "id_cliente", ignore = true)
    ArrayList<ClienteDTO> toListDto(ArrayList<Cliente> clients);
}

