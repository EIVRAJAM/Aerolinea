package mappers;

import dto.AerolineaDTO;
import models.Aerolinea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface AerolineaMapper {
    @Named("complete")
    AerolineaDTO toIdDto(Aerolinea aerolinea);
    Aerolinea toEntity(AerolineaDTO aerolineaDTO);
    @Named("listComplete")
    ArrayList<AerolineaDTO> toListIdDto(ArrayList<Aerolinea> airlines);
    ArrayList<Aerolinea> toListEntity(ArrayList<AerolineaDTO> AerolineaDTOs);
    @Named("withoutId")
    @Mapping(target = "id_aerolinea", ignore = true)
    AerolineaDTO toDto(Aerolinea aerolinea);
    @Named("listWithoutId")
    @Mapping(target = "id_aerolinea",ignore = true)
    ArrayList<AerolineaDTO> toListDto(ArrayList<Aerolinea> airlines);
}