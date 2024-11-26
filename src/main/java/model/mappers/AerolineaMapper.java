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

    /*
    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "aerolineas.vuelos_ids", target = "vuelos_ids", qualifiedByName = "listWithoutIdWithoutEntities")
    List<AerolineaDTO> toListDto(List<Aerolinea> aerolineas);//...ok


    @Named("completeWithoutFlight")
    @Mapping(target = "vuelos_ids", ignore = true)
    AerolineaDTO toIdDtoWithoutFlight(Aerolinea aerolinea);//...ok

    @Named("listCompleteWithoutFlight")
    @Mapping(target = "vuelos_ids", ignore = true)
    List<AerolineaDTO> toListIdDtoWithoutFlight(List<Aerolinea> aerolineas);//...ok

    @Named("entityWithoutFlight")
    @Mapping(target = "vuelos_ids", ignore = true)
    Aerolinea toEntityWithoutFlight(AerolineaDTO aerolineaDTO);//...ok

    @Named("listEntityWithoutFlight")
    @Mapping(target = "vuelos_ids", ignore = true)
    List<Aerolinea> toListEntityWithoutFlight(List<AerolineaDTO> airlineDto);//...ok

    @Named("withoutIdWithoutFlight")
    @Mapping(target = "vuelos_ids", ignore = true)
    @Mapping(target = "id", ignore = true)
    AerolineaDTO toDtoWithoutFlight(Aerolinea aerolinea);//...ok

    @Named("listWithoutIdWithoutFlight")
    @Mapping(target = "vuelos_ids", ignore = true)
    @Mapping(target = "id", ignore = true)
    List<AerolineaDTO> toListDtoWithoutFlight(List<Aerolinea> aerolineas);//...ok
*/
    @Mapping(target = "id", source = "id")
    Aerolinea toEntity(Long id);
}
