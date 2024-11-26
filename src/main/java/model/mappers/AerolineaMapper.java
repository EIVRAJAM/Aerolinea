package model.mappers;

import model.dto.AerolineaDTO;
import model.models.Aerolinea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = VueloMapper.class)
public interface AerolineaMapper {

    @Named("complete")
    @Mapping(target = "vuelos", ignore = true)
    AerolineaDTO toIdDto(Aerolinea aerolinea); //...ok

    @Mapping(target = "vuelos", ignore = true)
    Aerolinea toEntity(AerolineaDTO aerolineaDTO); //...ok

    @Named("listComplete")
    @Mapping(source = "aerolineas.vuelos_ids", target = "vuelos_ids", qualifiedByName = "listCompleteWithoutEntities")
    List<AerolineaDTO> toListIdDto(List<Aerolinea> aerolineas);//...ok

    @Mapping(source = "aerolineaDTOS.vuelos_ids", target = "vuelos_ids", qualifiedByName = "listEntityWithoutDtos")
    List<Aerolinea> toListEntity(List<AerolineaDTO> aerolineaDTOS);//...ok

    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vuelos", ignore = true)
    AerolineaDTO toDto(Aerolinea aerolinea);//...ok

    @Mapping(target = "id", source = "id")
    Aerolinea toEntity(Long id);
}
