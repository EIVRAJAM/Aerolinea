package model.mappers;

import model.dto.PasajeroDTO;
import model.models.Pasajero;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = ReservaMapper.class)
public interface PasajeroMapper {

    @Named("complete")
    @Mapping(source = "pasajero.reserva.id", target = "reserva_id")  // Mapeamos solo el id de la reserva
    PasajeroDTO toIdDto(Pasajero pasajero);

    @Named("listComplete")
    @Mapping(source = "pasajeros.reserva.id", target = "reserva_id")  // Mapeamos solo el id de la reserva
    List<PasajeroDTO> toListIdDto(List<Pasajero> pasajeros);

    @Mapping(source = "pasajeroDto.reserva_id", target = "reserva.id")  // Mapeamos el id de vuelta a la entidad
    Pasajero toEntity(PasajeroDTO pasajeroDto);

    @Mapping(source = "pasajerosDTO.reserva_id", target = "reserva.id")  // Mapeamos el id de vuelta a la entidad
    List<Pasajero> toListEntity(List<PasajeroDTO> pasajerosDTO);

    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "pasajero.reserva.id", target = "reserva_id")  // Mapeamos solo el id de la reserva
    PasajeroDTO toDto(Pasajero pasajero);

    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "pasajeros.reserva.id", target = "reserva_id")  // Mapeamos solo el id de la reserva
    List<PasajeroDTO> toListDto(List<Pasajero> pasajeros);

    @Named("completeWithoutReserve")
    @Mapping(target = "reserva_id", ignore = true)  // Ignoramos el campo de reserva
    PasajeroDTO toIdDtoWithoutReserve(Pasajero pasajero);

    @Named("listCompleteWithoutReserve")
    @Mapping(target = "reserva_id", ignore = true)  // Ignoramos el campo de reserva
    List<PasajeroDTO> toListIdDtoWithoutReserve(List<Pasajero> pasajeros);

    @Named("entityWithoutReserve")
    @Mapping(target = "reserva", ignore = true)  // Ignoramos la relación de reserva
    Pasajero toEntityWithoutReserve(Pasajero pasajero);

    @Named("listEntityWithoutReserve")
    @Mapping(target = "reserva", ignore = true)  // Ignoramos la relación de reserva
    List<Pasajero> toListEntityWithoutReserve(List<Pasajero> pasajeros);

    @Named("withoutIdWithoutReserve")
    @Mapping(target = "reserva_id", ignore = true)  // Ignoramos el campo de reserva
    @Mapping(target = "id", ignore = true)
    PasajeroDTO toDtoWithoutReserve(Pasajero pasajero);

    @Named("listWithoutIdWithoutReserve")
    @Mapping(target = "reserva_id", ignore = true)  // Ignoramos el campo de reserva
    @Mapping(target = "id", ignore = true)
    List<PasajeroDTO> toListDtoWithoutReserve(List<Pasajero> pasajeros);
}


/*@Mapper(componentModel = "spring", uses = ReservaMapper.class)
public interface PasajeroMapper {

    @Named("complete")
    @Mapping(source = "pasajero.reserva", target = "reserva", qualifiedByName = "completeWithoutEntities")
    PasajeroDTO toIdDto(Pasajero pasajero);

    @Named("listComplete")
    @Mapping(source = "pasajeros.reserva", target = "reserva", qualifiedByName = "completeWithoutEntities")
    List<PasajeroDTO> toListIdDto(List<Pasajero> pasajeros);

    @Mapping(source = "pasajeroDto.reserva", target = "reserva", qualifiedByName = "entityWithoutDtos")
    Pasajero toEntity(PasajeroDTO pasajeroDto);

    @Mapping(source = "pasajerosDTO.reserva", target = "reserva", qualifiedByName = "entityWithoutDtos")
    List<Pasajero> toListEntity(List<PasajeroDTO> pasajerosDTO);

    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "pasajero.reserva", target = "reserva", qualifiedByName = "withoutIdWithoutEntities")
    PasajeroDTO toDto(Pasajero pasajero);

    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "pasajeros.reserva", target = "reserva", qualifiedByName = "withoutIdWithoutEntities")
    List<PasajeroDTO> toListDto(List<Pasajero> pasajeros);

    @Named("completeWithoutReserve")
    @Mapping(target = "reserva", ignore = true)
    PasajeroDTO toIdDtoWithoutReserve(Pasajero pasajero);

    @Named("listCompleteWithoutReserve")
    @Mapping(target = "reserva", ignore = true)
    List<PasajeroDTO> toListIdDtoWithoutReserve(List<Pasajero> pasajeros);

    @Named("entityWithoutReserve")
    @Mapping(target = "reserva", ignore = true)
    Pasajero toEntityWithoutReserve(Pasajero pasajero);

    @Named("listEntityWithoutReserve")
    @Mapping(target = "reserva", ignore = true)
    List<Pasajero> toListEntityWithoutReserve(List<Pasajero> pasajeros);

    @Named("withoutIdWithoutReserve")
    @Mapping(target = "reserva", ignore = true)
    @Mapping(target = "id", ignore = true)
    PasajeroDTO toDtoWithoutReserve(Pasajero pasajero);

    @Named("listWithoutIdWithoutReserve")
    @Mapping(target = "reserva", ignore = true)
    @Mapping(target = "id", ignore = true)
    List<PasajeroDTO> toListDtoWithoutReserve(List<Pasajero> pasajeros);
}
*/