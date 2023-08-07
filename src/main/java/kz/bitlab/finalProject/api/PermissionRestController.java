package kz.bitlab.finalProject.api;

import kz.bitlab.finalProject.dto.PermissionDTO;
import kz.bitlab.finalProject.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PermissionRestController {

    private final PermissionService permissionService;

    @GetMapping(value = "/permissions")
    public List<PermissionDTO> getPermissions(){
        return permissionService.getPermissions();
    }

}
