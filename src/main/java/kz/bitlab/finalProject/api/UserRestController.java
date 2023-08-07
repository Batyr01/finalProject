package kz.bitlab.finalProject.api;

import kz.bitlab.finalProject.dto.UserDTO;
import kz.bitlab.finalProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping(value = "/users")
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(value = "/user")
    public UserDTO getUser(){
        return userService.getCurrentUser();
    }

    @GetMapping(value = "/users/{id}")
    public UserDTO getUser(@PathVariable(name = "id") Long id){
        return userService.getUser(id);
    }

    @PutMapping(value = "/users/update")
    public UserDTO updateProduct(@RequestBody UserDTO userDTO) {
        return userService.updateAdminUser(userDTO);
    }

    @DeleteMapping(value = "/users/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id){
        userService.deleteUser(id);
    }

}
