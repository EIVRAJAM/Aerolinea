package model.mappers;

import model.dto.VueloDTO;
import model.models.Aerolinea;
import model.models.Cliente;
import model.models.Vuelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;


@Mapper(componentModel = "spring", uses = {AerolineaMapper.class, AeropuertoMapper.class, ReservaMapper.class})
public interface VueloMapper {
    @Named("complete")
    @Mapping(source = "vuelo.aerolinea.id", target = "aerolinea_id")
    @Mapping(source = "vuelo.aeropuertoOrigen.id", target = "aeropuertoOrigen_id")
    @Mapping(source = "vuelo.aeropuertoDestino.id", target = "aeropuertoDestino_id")
    @Mapping(source = "vuelo.reservas", target = "reservas_id", qualifiedByName = "listToIds") //, qualifiedByName = "listCompleteWithoutEntities"
    VueloDTO toIdDto(Vuelo vuelo);

    @Named("listComplete")
    @Mapping(source = "vuelos.aerolinea.id", target = "aerolinea_id")//, qualifiedByName = "completeWithoutFlight"
    @Mapping(source = "vuelos.aeropuertoOrigen_id", target = "aeropuertoOrigen_id")//, qualifiedByName = "completeWithoutFlight"
    @Mapping(source = "vuelos.aeropuertoDestino_id", target = "aeropuertoDestino_id")//, qualifiedByName = "completeWithoutFlight"
    @Mapping(source = "vuelos.reservas", target = "reservas", qualifiedByName = "listToIds")
    List<VueloDTO> toListIdDto(List<Vuelo> vuelos);

    @Mapping(source = "vueloDTO.aerolinea_id", target = "aerolinea.id")//, qualifiedByName = "entityWithoutFlight"
    @Mapping(source = "vueloDTO.aeropuertoOrigen_id", target = "aeropuertoOrigen.id")//, qualifiedByName = "entityWithoutFlight"
    @Mapping(source = "vueloDTO.aeropuertoDestino_id", target = "aeropuertoDestino.id")//, qualifiedByName = "entityWithoutFlight"
    //@Mapping(source = "vueloDTO.reservas_id", target = "reservas", qualifiedByName = "idsToListReservas")
    Vuelo toEntity(VueloDTO vueloDTO);

    @Mapping(source = "vueloDto.aerolinea_id", target = "aerolinea_id", qualifiedByName = "entityWithoutFlight")
    @Mapping(source = "vueloDto.aeropuertoOrigen_id", target = "aeropuertoOrigen_id", qualifiedByName = "entityWithoutFlight")
    @Mapping(source = "vueloDto.aeropuertoDestino_id", target = "aeropuertoDestino_id", qualifiedByName = "entityWithoutFlight")
    @Mapping(source = "vueloDto.reservas_id", target = "reservas", qualifiedByName = "idsToListReservas")
    List<Vuelo> toListEntity(List<VueloDTO> vuelosDTO);

    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "vuelo.aerolinea.id", target = "aerolinea_id")//, qualifiedByName = "withoutIdWithoutFlight"
    @Mapping(source = "vuelo.aeropuertoOrigen.id", target = "aeropuertoOrigen_id")//, qualifiedByName = "withoutIdWithoutFlight"
    @Mapping(source = "vuelo.aeropuertoDestino.id", target = "aeropuertoDestino_id")// , qualifiedByName = "withoutIdWithoutFlight"
    @Mapping(source = "vuelo.reservas", target = "reservas_id", qualifiedByName = "listToIds")
    VueloDTO toDto(Vuelo vuelo);

    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "vuelos.aerolinea.id", target = "aerolinea_id")
    @Mapping(source = "vuelos.aeropuertoOrigen.id", target = "aeropuertoOrigen_id")
    @Mapping(source = "vuelos.aeropuertoDestino.id", target = "aeropuertoDestino_id")
    @Mapping(source = "vuelos.reservas", target = "reservas", qualifiedByName = "listToIds")
    List<VueloDTO> toListDto(List<Vuelo> vuelos);

/*    @Named("completeWithoutEntities")
    @Mapping(target = "aerolinea_id", ignore = true)
    @Mapping(target = "aeropuertoOrigen_id", ignore = true)
    @Mapping(target = "aeropuertoDestino_id", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    VueloDTO toIdDtoWithoutEntities(Vuelo vuelo);
*/

    @Named("listCompleteWithoutEntities")
    @Mapping(target = "aerolinea_id", ignore = true)
    @Mapping(target = "aeropuertoOrigen_id", ignore = true)
    @Mapping(target = "aeropuertoDestino_id", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    List<VueloDTO> toListIdDtoWithoutEntities(List<Vuelo> vuelos);

/*    @Named("withoutIdWithoutEntities")
    @Mapping(target = "aerolinea", ignore = true)
    @Mapping(target = "aeropuertoOrigen_id", ignore = true)
    @Mapping(target = "aeropuertoDestino_id", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    @Mapping(target = "id", ignore = true)
    VueloDTO toDtoWithoutEntities(Vuelo vuelo);
*/

 /*   @Named("toDtoWithoutEntities")
    @Mapping(target = "aerolinea.id", source = "aerolinea_id")
    @Mapping(target = "aeropuertoOrigen.id", source = "aeropuertoOrigen_id") // Accede al ID de la entidad
    @Mapping(target = "aeropuertoDestino.id", source = "aeropuertoDestino_id") // Accede al ID de la entidad
    @Mapping(target = "reservas", ignore = true) // Evita recursión infinita
    VueloDTO toDtoWithoutEntities(Vuelo vuelo);
    */

    @Named("listWithoutIdWithoutEntities")
    @Mapping(target = "aerolinea_id", ignore = true)
    @Mapping(target = "aeropuertoOrigen_id", ignore = true)
    @Mapping(target = "aeropuertoDestino_id", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    @Mapping(target = "id", ignore = true)
    List<VueloDTO> toListDtoWithoutEntities(List<Vuelo> vuelo);

  /*  @Named("EntityWithoutDtos")
    @Mapping(target = "aerolinea", ignore = true)
    @Mapping(target = "aeropuertoOrigen_id", ignore = true)
    @Mapping(target = "aeropuertoDestino_id", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    Vuelo toEntityWithoutDtos(VueloDTO vueloDTO);
    */

    @Named("toEntityWithoutDtos")
    @Mapping(target = "aerolinea.id", ignore = true)
    @Mapping(target = "aeropuertoOrigen.id", ignore = true) // Debes asignar esto manualmente si es necesario
    @Mapping(target = "aeropuertoDestino.id", ignore = true) // Lo mismo aquí
    @Mapping(target = "reservas", ignore = true)
    Vuelo toEntityWithoutDtos(VueloDTO vueloDTO);

    @Named("listEntityWithoutDtos")
    @Mapping(target = "aerolinea_id", ignore = true)
    @Mapping(target = "aeropuertoOrigen_id", ignore = true)
    @Mapping(target = "aeropuertoDestino_id", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    List<Vuelo> toListEntityWithoutDtos(List<VueloDTO> vuelosDTO);

    @Mapping(target = "id", source = "id")
    Vuelo toEntity(Long id);
}

