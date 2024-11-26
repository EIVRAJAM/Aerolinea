package model.mappers;

import model.dto.ReservaDTO;
import model.models.Reserva;
import org.mapstruct.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {PasajeroMapper.class, VueloMapper.class})
public interface ReservaMapper {

    @Named("reservaComplete")
    @Mapping(source = "reserva.cliente.id", target = "cliente_id") // Corregido: mapeamos cliente.id en lugar de cliente
    @Mapping(source = "reserva.pasajeros", target = "pasajeros", qualifiedByName = "pasajeroComplete")
    @Mapping(source = "reserva.vuelos", target = "vuelos_ids", qualifiedByName = "listVuelosToIds")
    ReservaDTO toIdDto(Reserva reserva);

    @Named("listReservasComplete")
    @IterableMapping(qualifiedByName = "reservaComplete")
    List<ReservaDTO> toListIdDto(List<Reserva> reservas);

    @Mapping(source = "reservaDTO.cliente_id", target = "cliente.id") // Corregido: mapeamos cliente_id a cliente.id
    @Mapping(source = "reservaDTO.pasajeros", target = "pasajeros", qualifiedByName = "listEntityWithoutReserve")
    //@Mapping(source = "reservaDTO.vuelos_ids", target = "vuelos_ids", qualifiedByName = "listEntityWithoutDtos") PENDIENTE POR CAMBIAR
    Reserva toEntity(ReservaDTO reservaDTO);

    @Mapping(source = "reservasDTO.cliente_id", target = "cliente.id") // Corregido: mapeamos cliente_id a cliente.id
    @Mapping(source = "reservasDTO.pasajeros", target = "pasajeros", qualifiedByName = "listEntityWithoutReserve")
    @Mapping(source = "reservasDTO.vuelos_ids", target = "vuelos_ids", qualifiedByName = "listEntityWithoutDtos")
    List<Reserva> toListEntity(List<ReservaDTO> reservasDTO);

    //este debe ser
    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "reserva.cliente.id", target = "cliente_id") // Corregido: mapeamos cliente.id
    @Mapping(source = "reserva.pasajeros", target = "pasajeros", qualifiedByName = "pasajeroComplete")
    @Mapping(source = "reserva.vuelos", target = "vuelos_ids", qualifiedByName = "listVuelosToIds")
    ReservaDTO toDto(Reserva reserva);

    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "reservas.cliente.id", target = "cliente_id") // Corregido: mapeamos cliente.id
    @Mapping(source = "reservas.pasajeros", target = "pasajeros", qualifiedByName = "listCompleteWithoutReserve")
    @Mapping(source = "reservas.vuelos_ids", target = "vuelos_ids", qualifiedByName = "listWithoutIdWithoutEntities")
    List<ReservaDTO> toListDto(List<Reserva> reservas);


    @Named("listCompleteWithoutEntities")
    @Mapping(target = "cliente_id", ignore = true) // Corregido: ahora ignoramos cliente_id
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos_ids", ignore = true)
    List<ReservaDTO> toListIdDtoWithoutEntities(List<Reserva> reservas);


    @Named("listWithoutIdWithoutEntities")
    @Mapping(target = "cliente_id", ignore = true) // Corregido: ahora ignoramos cliente_id
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos_ids", ignore = true)
    @Mapping(target = "id", ignore = true)
    List<ReservaDTO> toListDtoWithoutEntities(List<Reserva> reservas);


    @Named("listEntityWithoutDtos")
    @Mapping(target = "cliente", ignore = true) // Corregido: ahora ignoramos cliente
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos_ids", ignore = true)
    List<Reserva> toListEntityWithoutDtos(List<ReservaDTO> reservas);

    @Mapping(target = "id", source = "id")
    Reserva toEntity(Long id);


    @Named("listReservasToIds")
    default List<Long> mapReservasToIds(List<Reserva> reservas) {
        if (reservas == null) {
            return null;
        }
        return reservas.stream()
                .map(Reserva::getId)
                .collect(Collectors.toList());
    }

    /*
    // Método para convertir lista de IDs a Reservas
    @Named("idsToListReservas")
    default List<Reserva> mapIdsToReservas(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return List.of();
        }
        return reservaRepository.findAllById(ids); // Requiere acceso al repositorio
    }
    */
}



/*
@Mapper(componentModel = "spring", uses = {ClienteMapper.class, PasajeroMapper.class, VueloMapper.class})
public interface ReservaMapper {

    @Named("complete")
    @Mapping(source = "reserva.cliente", target = "cliente", qualifiedByName = "clienteWithoutReservas") // Corregir "client" por "cliente"
    @Mapping(source = "reserva.pasajeros", target = "pasajeros", qualifiedByName = "listCompleteWithoutReserve")
    @Mapping(source = "reserva.vuelos_ids", target = "vuelos_ids", qualifiedByName = "listCompleteWithoutEntities")
    ReservaDTO toIdDto(Reserva reserva);//...ok

    @Named("listComplete")
    @Mapping(source = "reservas.cliente", target = "cliente", qualifiedByName = "clienteWithoutReservas")
    @Mapping(source = "reservas.pasajeros", target = "pasajeros", qualifiedByName = "listCompleteWithoutReserve")
    @Mapping(source = "reservas.vuelos_ids", target = "vuelos_ids", qualifiedByName = "listCompleteWithoutEntities")
    List<ReservaDTO> toListIdDto(List<Reserva> reservas);//...ok

    @Mapping(source = "reservaDTO.cliente", target = "cliente", qualifiedByName = "clienteEntityWithoutReserve")
    @Mapping(source = "reservaDTO.pasajeros", target = "pasajeros", qualifiedByName = "listEntityWithoutReserve")
    @Mapping(source = "reservaDTO.vuelos_ids", target = "vuelos_ids", qualifiedByName = "listEntityWithoutDtos")
    Reserva toEntity(ReservaDTO reservaDTO);//...ok

    @Mapping(source = "reservasDTO.cliente", target = "cliente", qualifiedByName = "entityWithoutReserve")
    @Mapping(source = "reservasDTO.pasajeros", target = "pasajeros", qualifiedByName = "listEntityWithoutReserve")
    @Mapping(source = "reservasDTO.vuelos_ids", target = "vuelos_ids", qualifiedByName = "listEntityWithoutDtos")
    List<Reserva> toListEntity(List<ReservaDTO> reservasDTO);//...ok

    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "reserva.cliente", target = "cliente", qualifiedByName = "clienteWithoutReservas")
    @Mapping(source = "reserva.pasajeros", target = "pasajeros", qualifiedByName = "listWithoutIdWithoutReserve")
    @Mapping(source = "reserva.vuelos_ids", target = "vuelos_ids", qualifiedByName = "listWithoutIdWithoutEntities")
    ReservaDTO toDto(Reserva reserva);//...ok

    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "reservas.cliente", target = "cliente", qualifiedByName = "completeWithoutReserve")
    @Mapping(source = "reservas.pasajeros", target = "pasajeros", qualifiedByName = "listCompleteWithoutReserve")
    @Mapping(source = "reservas.vuelos_ids", target = "vuelos_ids", qualifiedByName = "listWithoutIdWithoutEntities")
    List<ReservaDTO> toListDto(List<Reserva> reservas);//...ok

    @Named("completeWithoutEntities")
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos_ids", ignore = true)
    ReservaDTO toIdDtoWithoutEntities(Reserva reserva);//...ok

    @Named("listCompleteWithoutEntities")
    @Mapping(target = "cliente", ignore = true, qualifiedByName = "clienteWithoutReservas")
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos_ids", ignore = true)
    List<ReservaDTO> toListIdDtoWithoutEntities(List<Reserva> reservas);//AQUI ESTA EL PROBLEM

    @Named("withoutIdWithoutEntities")
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos_ids", ignore = true)
    @Mapping(target = "id", ignore = true)
    ReservaDTO toDtoWithoutEntities(Reserva reserva);//...ok

    @Named("listWithoutIdWithoutEntities")
    @Mapping(target = "cliente", ignore = true, qualifiedByName = "clienteWithoutReservas")
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos_ids", ignore = true)
    @Mapping(target = "id", ignore = true)
    List<ReservaDTO> toListDtoWithoutEntities(List<Reserva> reservas);

    @Named("entityWithoutDtos")
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos_ids", ignore = true)
    Reserva toEntityWithoutDtos(ReservaDTO reservaDTO);

    @Named("listEntityWithoutDtos")
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos_ids", ignore = true)
    List<Reserva> toListEntityWithoutDtos(List<ReservaDTO> reservas);
}

 */