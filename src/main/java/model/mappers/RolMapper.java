package model.mappers;

import model.models.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RolMapper {
    @Mapping(target = "id", ignore = true)
    Rol toRole(String role);
    @Mapping(target = "id", ignore = true)
    Set<Rol> toRoles(Set<String> roles);
}