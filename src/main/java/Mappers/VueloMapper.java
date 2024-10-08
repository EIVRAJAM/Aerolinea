package Mappers;
import Dto.VueloDTO;
import com.example.aerolineamodels.models.Vuelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;

public interface VueloMapper {
    @Named("complete")
    VueloDTO toIdDto(Vuelo vuelo);
    @Named("listComplete")
    ArrayList<VueloDTO> toListIdDto(ArrayList<Vuelo> Vuelos);
    Vuelo toEntity(VueloDTO vueloDTO);
    ArrayList<Vuelo> toListEntity(ArrayList<VueloDTO> VueloDTOs);
    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    VueloDTO toDto(Vuelo vuelo);
    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    ArrayList<VueloDTO> toListDto(ArrayList<Vuelo> Vuelos);
}
