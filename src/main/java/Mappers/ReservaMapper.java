package Mappers;
import Dto.ReservaDTO;
import com.example.aerolineamodels.models.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;


@Mapper(componentModel = "spring")

public interface ReservaMapper {
    @Named("complete")
    ReservaDTO toIdDto(Reserva reserva);
    @Named("listComplete")
    ArrayList<ReservaDTO> toListIdDto(ArrayList<Reserva> reservas);
    Reserva toEntity(ReservaDTO reservaDto);
    ArrayList<Reserva> toListEntity(ArrayList<ReservaDTO> reservaDTOS);
    @Named("withoutId")
    @Mapping(target = "id", ignore = true)
    ReservaDTO toDto(Reserva reserva);
    @Named("listWithoutId")
    @Mapping(target = "id", ignore = true)
    ArrayList<ReservaDTO> toListDto(ArrayList<Reserva> reservas);
}
