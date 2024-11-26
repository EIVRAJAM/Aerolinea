package model.services;

import lombok.AllArgsConstructor;
import model.dto.AerolineaDTO;
import model.mappers.AerolineaMapper;
import model.mappers.VueloMapper;
import model.models.Aerolinea;
import model.repositories.AerolineaRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Lazy))
public class AerolineaServicesImpl implements AerolineaServices {
    private AerolineaRepository aerolineaRepository;
    private VueloMapper vueloMapper;
    private AerolineaMapper aerolineaMapper;

    @Override
    public AerolineaDTO save(AerolineaDTO airline) {
        return aerolineaMapper.toIdDto(aerolineaRepository.save(aerolineaMapper.toEntity(airline)));
    }

    @Override
    public Optional<AerolineaDTO> findById(Long id) {
        return aerolineaRepository.findById(id).map(aerolineaMapper::toIdDto);
    }

    @Override
    public Optional<AerolineaDTO> update(Long id, AerolineaDTO airline) {
        return aerolineaRepository.findById(id).map(oldAirline -> {
            if(airline.codigo_aerolinea() != null) { oldAirline.setCodigo_aerolinea(airline.codigo_aerolinea()); }
            if(airline.nombre() != null) { oldAirline.setNombre(airline.nombre()); }
            if(airline.pais_origen() != null) { oldAirline.setPais_origen(airline.pais_origen()); }
            if(airline.vuelos() != null) { oldAirline.setVuelos(vueloMapper.toListEntity(airline.vuelos())); }

            return aerolineaMapper.toIdDto(aerolineaRepository.save(oldAirline));
        });
    }

    @Override
    public List<AerolineaDTO> findAll() {
        return aerolineaMapper.toListIdDto(aerolineaRepository.findAll());
    }

    @Override
    public List<AerolineaDTO> findByName(String name) {
        Aerolinea a = new Aerolinea();
        a.setNombre(name);
        Example<Aerolinea> example = Example.of(a);
        return aerolineaMapper.toListIdDto(aerolineaRepository.findAll(example));
    }

    @Override
    public void deleteById(Long id) {
        aerolineaRepository.deleteById(id);
    }

}
