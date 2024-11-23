package model.mappers;

import model.dto.VueloDTO;
import model.models.Vuelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AerolineaMapper.class, AeropuertoMapper.class, ReservaMapper.class})
public interface VueloMapper {
    @Named("complete")
    @Mapping(source = "vuelo.aerolinea", target = "aerolinea", qualifiedByName = "completeWithoutFlight")
    @Mapping(source = "vuelo.aeropuertoOrigen", target = "aeropuertoOrigen", qualifiedByName = "completeWithoutFlight")
    @Mapping(source = "vuelo.aeropuertoDestino", target = "aeropuertoDestino", qualifiedByName = "completeWithoutFlight")
    @Mapping(source = "vuelo.reservas", target = "reservas", qualifiedByName = "listCompleteWithoutEntities")
    VueloDTO toIdDto(Vuelo vuelo);

    @Named("listComplete")
    @Mapping(source = "vuelos.aerolinea", target = "aerolinea", qualifiedByName = "completeWithoutFlight")
    @Mapping(source = "vuelos.aeropuertoOrigen", target = "aeropuertoOrigen", qualifiedByName = "completeWithoutFlight")
    @Mapping(source = "vuelos.aeropuertoDestino", target = "aeropuertoDestino", qualifiedByName = "completeWithoutFlight")
    @Mapping(source = "vuelos.reservas", target = "reservas", qualifiedByName = "listCompleteWithoutEntities")
    List<VueloDTO> toListIdDto(List<Vuelo> vuelos);

    @Mapping(source = "vueloDTO.aerolinea", target = "aerolinea", qualifiedByName = "entityWithoutFlight")
    @Mapping(source = "vueloDTO.aeropuertoOrigen", target = "aeropuertoOrigen", qualifiedByName = "entityWithoutFlight")
    @Mapping(source = "vueloDTO.aeropuertoDestino", target = "aeropuertoDestino", qualifiedByName = "entityWithoutFlight")
    @Mapping(source = "vueloDTO.reservas", target = "reservas", qualifiedByName = "listEntityWithoutDtos")
    Vuelo toEntity(VueloDTO vueloDTO);

    @Mapping(source = "vueloDto.aerolinea", target = "aerolinea", qualifiedByName = "entityWithoutFlight")
    @Mapping(source = "vueloDto.aeropuertoOrigen", target = "aeropuertoOrigen", qualifiedByName = "entityWithoutFlight")
    @Mapping(source = "vueloDto.aeropuertoDestino", target = "aeropuertoDestino", qualifiedByName = "entityWithoutFlight")
    @Mapping(source = "vueloDto.reservas", target = "reservas", qualifiedByName = "listEntityWithoutDtos")
    List<Vuelo> toListEntity(List<VueloDTO> vuelosDTO);

    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "vuelo.aerolinea", target = "aerolinea", qualifiedByName = "withoutIdWithoutFlight")
    @Mapping(source = "vuelo.aeropuertoOrigen", target = "aeropuertoOrigen", qualifiedByName = "withoutIdWithoutFlight")
    @Mapping(source = "vuelo.aeropuertoDestino", target = "aeropuertoDestino", qualifiedByName = "withoutIdWithoutFlight")
    @Mapping(source = "vuelo.reservas", target = "reservas", qualifiedByName = "listWithoutIdWithoutEntities")
    VueloDTO toDto(Vuelo vuelo);

    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "vuelo.aerolinea", target = "aerolinea", qualifiedByName = "withoutIdWithoutFlight")
    @Mapping(source = "vuelo.aeropuertoOrigen", target = "aeropuertoOrigen", qualifiedByName = "withoutIdWithoutFlight")
    @Mapping(source = "vuelo.aeropuertoDestino", target = "aeropuertoDestino", qualifiedByName = "withoutIdWithoutFlight")
    @Mapping(source = "vuelo.reservas", target = "reservas", qualifiedByName = "listWithoutIdWithoutEntities")
    List<VueloDTO> toListDto(List<Vuelo> vuelos);

    @Named("completeWithoutEntities")
    @Mapping(target = "aerolinea", ignore = true)
    @Mapping(target = "aeropuertoOrigen", ignore = true)
    @Mapping(target = "aeropuertoDestino", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    VueloDTO toIdDtoWithoutEntities(Vuelo vuelo);

    @Named("listCompleteWithoutEntities")
    @Mapping(target = "aerolinea", ignore = true)
    @Mapping(target = "aeropuertoOrigen", ignore = true)
    @Mapping(target = "aeropuertoDestino", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    List<VueloDTO> toListIdDtoWithoutEntities(List<Vuelo> vuelos);

    @Named("withoutIdWithoutEntities")
    @Mapping(target = "aerolinea", ignore = true)
    @Mapping(target = "aeropuertoOrigen", ignore = true)
    @Mapping(target = "aeropuertoDestino", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    @Mapping(target = "id", ignore = true)
    VueloDTO toDtoWithoutEntities(Vuelo vuelo);

    @Named("listWithoutIdWithoutEntities")
    @Mapping(target = "aerolinea", ignore = true)
    @Mapping(target = "aeropuertoOrigen", ignore = true)
    @Mapping(target = "aeropuertoDestino", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    @Mapping(target = "id", ignore = true)
    List<VueloDTO> toListDtoWithoutEntities(List<Vuelo> vuelo);

    @Named("EntityWithoutDtos")
    @Mapping(target = "aerolinea", ignore = true)
    @Mapping(target = "aeropuertoOrigen", ignore = true)
    @Mapping(target = "aeropuertoDestino", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    Vuelo toEntityWithoutDtos(VueloDTO vueloDTO);

    @Named("listEntityWithoutDtos")
    @Mapping(target = "aerolinea", ignore = true)
    @Mapping(target = "aeropuertoOrigen", ignore = true)
    @Mapping(target = "aeropuertoDestino", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    List<Vuelo> toListEntityWithoutDtos(List<VueloDTO> vuelosDTO);
}
