package kz.bitlab.finalProject.mapper;


import kz.bitlab.finalProject.dto.PermissionDTO;
import kz.bitlab.finalProject.model.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionDTO toDto(Permission permission);

    Permission toModel(PermissionDTO permissionDTO);

    List<PermissionDTO> toDtoList(List<Permission> permissionList);

    List<Permission> toModelList(List<PermissionDTO> permissionDTOList);

}
