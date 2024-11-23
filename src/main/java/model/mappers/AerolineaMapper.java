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
    @Mapping(source = "vuelos", target = "vuelos", qualifiedByName = "listCompleteWithoutEntities")
    AerolineaDTO toIdDto(Aerolinea aerolinea); //...ok

    @Mapping(source = "aerolineaDTO.vuelos", target = "vuelos", qualifiedByName = "listEntityWithoutDtos")
    Aerolinea toEntity(AerolineaDTO aerolineaDTO); //...ok

    @Named("listComplete")
    @Mapping(source = "aerolineas.vuelos", target = "vuelos", qualifiedByName = "listCompleteWithoutEntities")
    List<AerolineaDTO> toListIdDto(List<Aerolinea> aerolineas);//...ok

    @Mapping(source = "aerolineaDTOS.vuelos", target = "vuelos", qualifiedByName = "listEntityWithoutDtos")
    List<Aerolinea> toListEntity(List<AerolineaDTO> aerolineaDTOS);//...ok

    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "aerolinea.vuelos", target = "vuelos", qualifiedByName = "listWithoutIdWithoutEntities")
    AerolineaDTO toDto(Aerolinea aerolinea);//...ok

    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "aerolineas.vuelos", target = "vuelos", qualifiedByName = "listWithoutIdWithoutEntities")
    List<AerolineaDTO> toListDto(List<Aerolinea> aerolineas);//...ok

    @Named("completeWithoutFlight")
    @Mapping(target = "vuelos", ignore = true)
    AerolineaDTO toIdDtoWithoutFlight(Aerolinea aerolinea);//...ok

    @Named("listCompleteWithoutFlight")
    @Mapping(target = "vuelos", ignore = true)
    List<AerolineaDTO> toListIdDtoWithoutFlight(List<Aerolinea> aerolineas);//...ok

    @Named("entityWithoutFlight")
    @Mapping(target = "vuelos", ignore = true)
    Aerolinea toEntityWithoutFlight(AerolineaDTO aerolineaDTO);//...ok

    @Named("listEntityWithoutFlight")
    @Mapping(target = "vuelos", ignore = true)
    List<Aerolinea> toListEntityWithoutFlight(List<AerolineaDTO> airlineDto);//...ok

    @Named("withoutIdWithoutFlight")
    @Mapping(target = "vuelos", ignore = true)
    @Mapping(target = "id", ignore = true)
    AerolineaDTO toDtoWithoutFlight(Aerolinea aerolinea);//...ok

    @Named("listWithoutIdWithoutFlight")
    @Mapping(target = "vuelos", ignore = true)
    @Mapping(target = "id", ignore = true)
    List<AerolineaDTO> toListDtoWithoutFlight(List<Aerolinea> aerolineas);//...ok
}
