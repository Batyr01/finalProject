package kz.bitlab.finalProject.service;

import kz.bitlab.finalProject.dto.PermissionDTO;
import kz.bitlab.finalProject.mapper.PermissionMapper;
import kz.bitlab.finalProject.model.Permission;
import kz.bitlab.finalProject.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PermissionMapper permissionMapper;

    public Permission findRoleByName(String roleName){
        return permissionRepository.findByName(roleName);

    }

    public List<PermissionDTO> getPermissions(){
        return permissionMapper.toDtoList(permissionRepository.findAll());
    }

}
