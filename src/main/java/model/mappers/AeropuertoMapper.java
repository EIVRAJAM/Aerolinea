package model.mappers;

import model.dto.AeropuertoDTO;
import model.models.Aeropuerto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = VueloMapper.class)
public interface AeropuertoMapper {

    @Named("complete")
    @Mapping(source = "aeropuerto.vuelosOrigen", target = "vuelosOrigen", qualifiedByName = "listCompleteWithoutEntities")
    @Mapping(source = "aeropuerto.vuelosDestino", target = "vuelosDestino", qualifiedByName = "listCompleteWithoutEntities")
    AeropuertoDTO toIdDto(Aeropuerto aeropuerto);//...ok

    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "aeropuerto.vuelosOrigen", target = "vuelosOrigen", qualifiedByName = "listWithoutIdWithoutEntities")
    @Mapping(source = "aeropuerto.vuelosDestino", target = "vuelosDestino", qualifiedByName = "listWithoutIdWithoutEntities")
    AeropuertoDTO toDto(Aeropuerto aeropuerto);//...ok

    @Named("listComplete")
    @Mapping(source = "aeropuertos.vuelosOrigen", target = "vuelosOrigen", qualifiedByName = "listCompleteWithoutEntities")
    @Mapping(source = "aeropuertos.vuelosDestino", target = "vuelosDestino", qualifiedByName = "listCompleteWithoutEntities")
    List<AeropuertoDTO> toListIdDto(List<Aeropuerto> aeropuertos);//...ok

    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "aeropuertos.vuelosOrigen", target = "vuelosOrigen", qualifiedByName = "listWithoutIdWithoutEntities")
    @Mapping(source = "aeropuertos.vuelosDestino", target = "vuelosDestino", qualifiedByName = "listWithoutIdWithoutEntities")
    List<AeropuertoDTO> toListDto(List<Aeropuerto> aeropuertos);//...ok

    @Mapping(source = "aeropuertoDTO.vuelosOrigen", target = "vuelosOrigen", qualifiedByName = "listEntityWithoutDtos")
    @Mapping(source = "aeropuertoDTO.vuelosDestino", target = "vuelosDestino", qualifiedByName = "listEntityWithoutDtos")
    Aeropuerto toEntity(AeropuertoDTO aeropuertoDTO);//...ok

    @Mapping(source = "aeropuertosDTO.vuelosOrigen", target = "vuelosOrigen", qualifiedByName = "listEntityWithoutDtos")
    @Mapping(source = "aeropuertosDTO.vuelosDestino", target = "vuelosDestino", qualifiedByName = "listEntityWithoutDtos")
    List<Aeropuerto> toListEntity(List<AeropuertoDTO> aeropuertosDTO);//...ok

    @Named("completeWithoutFlight")
    @Mapping(target = "vuelosOrigen", ignore = true)
    @Mapping(target = "vuelosDestino", ignore = true)
    AeropuertoDTO toIdDtoWithoutFlight(Aeropuerto aeropuerto);//...ok

    @Named("listCompleteWithoutFlight")
    @Mapping(target = "vuelosOrigen", ignore = true)
    @Mapping(target = "vuelosDestino", ignore = true)
    List<AeropuertoDTO> toListIdDtoWithoutFlight(List<Aeropuerto> aeropuertos);//...ok

    @Named("withoutIdWithoutFlight")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vuelosOrigen", ignore = true)
    @Mapping(target = "vuelosDestino", ignore = true)
    AeropuertoDTO toDtoWithoutFlight(Aeropuerto aeropuerto);//...ok

    @Named("listWithoutIdWithoutFlight")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vuelosOrigen", ignore = true)
    @Mapping(target = "vuelosDestino", ignore = true)
    List<AeropuertoDTO> toListDtoWithoutFlight(List<Aeropuerto> aeropuertos);//...ok

    @Named("entityWithoutFlight")
    @Mapping(target = "vuelosOrigen", ignore = true)
    @Mapping(target = "vuelosDestino", ignore = true)
    Aeropuerto toEntityWithoutFlight(AeropuertoDTO aeropuertoDTO);//...ok

    @Named("listEntityWithoutFlight")
    @Mapping(target = "vuelosOrigen", ignore = true)
    @Mapping(target = "vuelosDestino", ignore = true)
    List<Aeropuerto> toListEntityWithoutFlight(List<AeropuertoDTO> aeropuertosDTO);//...ok
}
