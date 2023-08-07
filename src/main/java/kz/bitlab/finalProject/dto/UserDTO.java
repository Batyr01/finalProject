package kz.bitlab.finalProject.dto;

import kz.bitlab.finalProject.model.Permission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String email;
    private String fullName;
    private List<Permission> permissions;

}
