package mappers;

import dto.PasajeroDTO;
import models.Pasajero;
import org.mapstruct.Named;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface PasajeroMapper {
    @Named("complete")
    PasajeroDTO toIdDto(Pasajero pasajero);
    @Named("listComplete")
    ArrayList<PasajeroDTO> toListIdDto(ArrayList<Pasajero> pasajeros);
    Pasajero toEntity(PasajeroDTO pasajeroDTO);
    ArrayList<Pasajero> toListEntity(ArrayList<PasajeroDTO> pasajeroDTOs);
    @Named("withoutId")
    @Mapping(target="id_pasajero",ignore = true)
    PasajeroDTO toDto(Pasajero pasajero);
    @Named("listWithoutId")
    @Mapping(target="id_pasajero",ignore = true)
    ArrayList<PasajeroDTO> toListDto(ArrayList<Pasajero> pasajeros);
}
