package model.mappers;

import model.dto.PasajeroDTO;
import model.models.Pasajero;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = ReservaMapper.class)
public interface PasajeroMapper {

    @Named("pasajeroComplete")
    @Mapping(source = "pasajero.reserva.id", target = "reserva_id")  // Mapeamos solo el id de la reserva
    PasajeroDTO toIdDto(Pasajero pasajero);

    @Named("listComplete")
    @IterableMapping(qualifiedByName = "pasajeroComplete") // Mapeamos solo el id de la reserva
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

    @Named("listEntityWithoutReserve")
    @Mapping(target = "reserva", ignore = true)  // Ignoramos la relación de reserva
    List<Pasajero> toListEntityWithoutReserve(List<Pasajero> pasajeros);
}