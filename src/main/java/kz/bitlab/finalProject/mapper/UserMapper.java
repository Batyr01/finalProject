package kz.bitlab.finalProject.mapper;

import kz.bitlab.finalProject.dto.UserDTO;
import kz.bitlab.finalProject.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);

    User toModel(UserDTO userDTO);

    List<UserDTO> toDtoList(List<User> userList);

    List<User> toModelList(List<UserDTO> userDTOList);

}
