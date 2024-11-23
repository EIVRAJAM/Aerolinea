package model.mappers;

import model.dto.ReservaDTO;
import model.models.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class, PasajeroMapper.class, VueloMapper.class})
public interface ReservaMapper {

    @Named("complete")
    @Mapping(source = "reserva.cliente", target = "cliente", qualifiedByName = "completeWithoutReserve") // Corregir "client" por "cliente"
    @Mapping(source = "reserva.pasajeros", target = "pasajeros", qualifiedByName = "listCompleteWithoutReserve")
    @Mapping(source = "reserva.vuelos", target = "vuelos", qualifiedByName = "listCompleteWithoutEntities")
    ReservaDTO toIdDto(Reserva reserva);//...ok

    @Named("listComplete")
    @Mapping(source = "reservas.cliente", target = "cliente", qualifiedByName = "completeWithoutReserve")
    @Mapping(source = "reservas.pasajeros", target = "pasajeros", qualifiedByName = "listCompleteWithoutReserve")
    @Mapping(source = "reservas.vuelos", target = "vuelos", qualifiedByName = "listCompleteWithoutEntities")
    List<ReservaDTO> toListIdDto(List<Reserva> reservas);//...ok

    @Mapping(source = "reservaDTO.cliente", target = "cliente", qualifiedByName = "entityWithoutReserve")
    @Mapping(source = "reservaDTO.pasajeros", target = "pasajeros", qualifiedByName = "listEntityWithoutReserve")
    @Mapping(source = "reservaDTO.vuelos", target = "vuelos", qualifiedByName = "listEntityWithoutDtos")
    Reserva toEntity(ReservaDTO reservaDTO);//...ok

    @Mapping(source = "reservasDTO.cliente", target = "cliente", qualifiedByName = "entityWithoutReserve")
    @Mapping(source = "reservasDTO.pasajeros", target = "pasajeros", qualifiedByName = "listEntityWithoutReserve")
    @Mapping(source = "reservasDTO.vuelos", target = "vuelos", qualifiedByName = "listEntityWithoutDtos")
    List<Reserva> toListEntity(List<ReservaDTO> reservasDTO);//...ok

    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "reserva.cliente", target = "cliente", qualifiedByName = "withoutIdWithoutReserve")
    @Mapping(source = "reserva.pasajeros", target = "pasajeros", qualifiedByName = "listWithoutIdWithoutReserve")
    @Mapping(source = "reserva.vuelos", target = "vuelos", qualifiedByName = "listWithoutIdWithoutEntities")
    ReservaDTO toDto(Reserva reserva);//...ok

    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "reservas.cliente", target = "cliente", qualifiedByName = "completeWithoutReserve")
    @Mapping(source = "reservas.pasajeros", target = "pasajeros", qualifiedByName = "listCompleteWithoutReserve")
    @Mapping(source = "reservas.Vuelos", target = "Vuelos", qualifiedByName = "listWithoutIdWithoutEntities")
    List<ReservaDTO> toListDto(List<Reserva> reservas);//...ok

    @Named("completeWithoutEntities")
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos", ignore = true)
    ReservaDTO toIdDtoWithoutEntities(Reserva reserva);//...ok

    @Named("listCompleteWithoutEntities")
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos", ignore = true)
    List<ReservaDTO> toListIdDtoWithoutEntities(List<Reserva> reservas);//...ok

    @Named("withoutIdWithoutEntities")
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos", ignore = true)
    @Mapping(target = "id", ignore = true)
    ReservaDTO toDtoWithoutEntities(Reserva reserva);//...ok

    @Named("listWithoutIdWithoutEntities")
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos", ignore = true)
    @Mapping(target = "id", ignore = true)
    List<ReservaDTO> toListDtoWithoutEntities(List<Reserva> reservas);

    @Named("entityWithoutDtos")
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos", ignore = true)
    Reserva toEntityWithoutDtos(ReservaDTO reservaDTO);

    @Named("listEntityWithoutDtos")
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "pasajeros", ignore = true)
    @Mapping(target = "vuelos", ignore = true)
    List<Reserva> toListEntityWithoutDtos(List<ReservaDTO> reservas);
}
