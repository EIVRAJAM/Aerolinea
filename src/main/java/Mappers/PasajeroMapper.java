package Mappers;

import Dto.ClienteDTO;
import Dto.PasajeroDTO;
import com.example.aerolineamodels.models.Pasajero;
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
    @Mapping(target="id",ignore = true)
    PasajeroDTO toDto(Pasajero pasajero);
    @Named("listWithoutId")
    @Mapping(target="id",ignore = true)
    ArrayList<PasajeroDTO> toListDto(ArrayList<Pasajero> pasajeros);
}
