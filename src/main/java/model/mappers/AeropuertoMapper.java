package mappers;

import dto.AeropuertoDTO;
import models.Aeropuerto;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;


public interface AeropuertoMapper {
    @Named("complete")
    AeropuertoDTO toIdDto(Aeropuerto aeropuerto);
    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    AeropuertoDTO toDto(Aeropuerto aeropuerto);
    @Named("listComplete")
    ArrayList<AeropuertoDTO> toListIdDto(ArrayList<Aeropuerto> aeropuertos);

    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    ArrayList<AeropuertoDTO> toListDto(ArrayList<Aeropuerto> aeropuertos);

    Aeropuerto toEntity(AeropuertoDTO aeropuertoDTO);
    ArrayList<Aeropuerto> toListEntity(ArrayList<AeropuertoDTO> aeropuertoDTOs);
}
