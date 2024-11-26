package model.mappers;

import model.dto.VueloDTO;
import model.models.Aerolinea;
import model.models.Cliente;
import model.models.Reserva;
import model.models.Vuelo;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring", uses = {AerolineaMapper.class, AeropuertoMapper.class, ReservaMapper.class})
public interface VueloMapper {
    @Named("vueloComplete")
    @Mapping(source = "vuelo.aerolinea.id", target = "aerolinea_id")
    @Mapping(source = "vuelo.aeropuertoOrigen.id", target = "aeropuertoOrigen_id")
    @Mapping(source = "vuelo.aeropuertoDestino.id", target = "aeropuertoDestino_id")
    @Mapping(source = "vuelo.reservas", target = "reservas_id", qualifiedByName = "listReservasToIds")
    VueloDTO toIdDto(Vuelo vuelo);

    //el q se esta usando posible error
    //SE USA EN SERVICIO

    @Named("listComplete")
    @IterableMapping(qualifiedByName = "vueloComplete") // Aplica el método 'vueloComplete' para cada elemento de la lista
    List<VueloDTO> toListIdDto(List<Vuelo> vuelos);


    //IMPORTANTE!!!!! ESTE SIRVE.
    //se usa en mapper
    //se USA EN UN SERVICIO
    @Named("completeVueloDTO")
    @Mapping(source = "vueloDTO.aerolinea_id", target = "aerolinea.id")//, qualifiedByName = "entityWithoutFlight"
    @Mapping(source = "vueloDTO.aeropuertoOrigen_id", target = "aeropuertoOrigen.id")//, qualifiedByName = "entityWithoutFlight"
    @Mapping(source = "vueloDTO.aeropuertoDestino_id", target = "aeropuertoDestino.id")//, qualifiedByName = "entityWithoutFlight"
    //@Mapping(source = "vueloDTO.reservas_id", target = "reservas", qualifiedByName = "idsToListReservas")
    Vuelo toEntity(VueloDTO vueloDTO);

    //se usa en los mapping
    @Mapping(source = "vueloDto.aerolinea_id", target = "aerolinea_id", qualifiedByName = "entityWithoutFlight")
    @Mapping(source = "vueloDto.aeropuertoOrigen_id", target = "aeropuertoOrigen_id", qualifiedByName = "entityWithoutFlight")
    @Mapping(source = "vueloDto.aeropuertoDestino_id", target = "aeropuertoDestino_id", qualifiedByName = "entityWithoutFlight")
    @Mapping(source = "vueloDto.reservas_id", target = "reservas", qualifiedByName = "idsToListReservas")
    List<Vuelo> toListEntity(List<VueloDTO> vuelosDTO);

    //sin uso
    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "vuelo.aerolinea.id", target = "aerolinea_id")//, qualifiedByName = "withoutIdWithoutFlight"
    @Mapping(source = "vuelo.aeropuertoOrigen.id", target = "aeropuertoOrigen_id")//, qualifiedByName = "withoutIdWithoutFlight"
    @Mapping(source = "vuelo.aeropuertoDestino.id", target = "aeropuertoDestino_id")// , qualifiedByName = "withoutIdWithoutFlight"
    @Mapping(source = "vuelo.reservas", target = "reservas_id", qualifiedByName = "listReservasToIds")
    VueloDTO toDto(Vuelo vuelo);


    //Sin uso
    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "vuelos_ids.aerolinea.id", target = "aerolinea_id")
    @Mapping(source = "vuelos_ids.aeropuertoOrigen.id", target = "aeropuertoOrigen_id")
    @Mapping(source = "vuelos_ids.aeropuertoDestino.id", target = "aeropuertoDestino_id")
    @Mapping(source = "vuelos_ids.reservas", target = "reservas", qualifiedByName = "listReservasToIds")
    List<VueloDTO> toListDto(List<Vuelo> vuelos);

    //este se usa en los mappers
    @Named("listCompleteWithoutEntities")
    @Mapping(source = "vuelos_ids.aerolinea.id", target = "aerolinea_id")
    @Mapping(source = "vuelos_ids.aeropuertoOrigen.id", target = "aeropuertoOrigen_id")
    @Mapping(source = "vuelos_ids.aeropuertoDestino.id", target = "aeropuertoDestino_id")
    @Mapping(source = "vuelos_ids.reservas", target = "reservas_id", qualifiedByName = "listReservasToIds")
    List<VueloDTO> toListIdDtoWithoutEntities(List<Vuelo> vuelos);

    //Se usa en los mappers
    //PARA CORREGIR ---!!!!!!!!!!!!!!!!!!
    @Named("listWithoutIdWithoutEntities")
    @Mapping(source = "vuelo.aerolinea.id", target = "aerolinea_id")
    @Mapping(source = "vuelo.aeropuertoOrigen.id", target = "aeropuertoOrigen_id")
    @Mapping(source = "vuelo.aeropuertoDestino.id", target = "aeropuertoDestino_id")
    @Mapping(target = "reservas", ignore = true)
    @Mapping(target = "id", ignore = true)
    List<VueloDTO> toListDtoWithoutEntities(List<Vuelo> vuelo);

    //se usa en los mappers
    @Named("listEntityWithoutDtos")
    @Mapping(target = "aerolinea_id", ignore = true)
    @Mapping(target = "aeropuertoOrigen_id", ignore = true)
    @Mapping(target = "aeropuertoDestino_id", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    List<Vuelo> toListEntityWithoutDtos(List<VueloDTO> vuelosDTO);

    @Named("listVuelosToIds")
    default List<Long> mapVuelosToIds(List<Vuelo> vuelos) {
        if (vuelos == null) {
            return null;
        }

        return vuelos.stream()
                .map(Vuelo::getId)
                .collect(Collectors.toList());
    }
}

