package model.mappers;

import model.dto.AeropuertoDTO;
import model.models.Aeropuerto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;


@Mapper(componentModel = "spring", uses = VueloMapper.class)
public interface AeropuertoMapper {

    @Named("aeropuertoComplete")
    @Mapping(source = "vuelosOrigen", target = "vuelosOrigen", qualifiedByName = "listVuelosComplete")
    @Mapping(source = "vuelosDestino", target = "vuelosDestino", qualifiedByName = "listVuelosComplete")
    AeropuertoDTO toIdDto(Aeropuerto aeropuerto);

    @Named("AeropuertoWithoutId")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "vuelosOrigen", target = "vuelosOrigen", qualifiedByName = "listVuelosComplete")
    @Mapping(source = "vuelosDestino", target = "vuelosDestino", qualifiedByName = "listVuelosComplete")
    AeropuertoDTO toDto(Aeropuerto aeropuerto);

    @Named("listComplete")
    @IterableMapping(qualifiedByName = "aeropuertoComplete")
    List<AeropuertoDTO> toListIdDto(List<Aeropuerto> aeropuertos);

    @Mapping(source = "aeropuertoDTO.vuelosOrigen", target = "vuelosOrigen", qualifiedByName = "listEntityWithoutDtos")
    @Mapping(source = "aeropuertoDTO.vuelosDestino", target = "vuelosDestino", qualifiedByName = "listEntityWithoutDtos")
    Aeropuerto toEntity(AeropuertoDTO aeropuertoDTO);

    @Mapping(source = "aeropuertosDTO.vuelosOrigen", target = "vuelosOrigen", qualifiedByName = "listEntityWithoutDtos")
    @Mapping(source = "aeropuertosDTO.vuelosDestino", target = "vuelosDestino", qualifiedByName = "listEntityWithoutDtos")
    List<Aeropuerto> toListEntity(List<AeropuertoDTO> aeropuertosDTO);

    @Mapping(target = "id", source = "id")
    Aeropuerto toEntity(Long id);
}
