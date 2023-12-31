package kz.bitlab.finalProject.service;

import kz.bitlab.finalProject.dto.UserDTO;
import kz.bitlab.finalProject.mapper.UserMapper;
import kz.bitlab.finalProject.model.Permission;
import kz.bitlab.finalProject.model.User;
import kz.bitlab.finalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;


public class UserService implements UserDetailsService {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user != null){
            return user;
        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    public User addUser(User user){
        User checkUser = userRepository.findByEmail(user.getEmail());
        if (checkUser == null){
            Permission role = permissionService.findRoleByName("ROLE_USER");
            List<Permission> permissions = new ArrayList<>();
            permissions.add(role);
            user.setPermissions(permissions);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(String fullName, String email){
        User currentUser = getCurrentSessionUser();
        if (currentUser.getEmail().equals(email)){
            currentUser.setFullName(fullName);
            return userRepository.save(currentUser);
        }else{
            User checkUser = userRepository.findByEmail(email);
            if (checkUser == null){
                currentUser.setEmail(email);
                currentUser.setFullName(fullName);
                return userRepository.save(currentUser);
            }
        }
        return null;
    }

    public UserDTO updateAdminUser(UserDTO userDTO){
        User oldUser = userRepository.findById(userDTO.getId()).orElse(null);
        if (oldUser!=null){
            oldUser.setFullName(userDTO.getFullName());
            oldUser.setEmail(userDTO.getEmail());
            oldUser.setPermissions(userDTO.getPermissions());
            return userMapper.toDto(userRepository.save(oldUser));
        }
        return null;
    }

    public User updatePassword(String oldPassword, String newPassword){
        User currentUser = getCurrentSessionUser();
        if (passwordEncoder.matches(oldPassword, currentUser.getPassword())){
            currentUser.setPassword(passwordEncoder.encode(newPassword));
            return userRepository.save(currentUser);
        }
        return null;
    }

    public UserDTO getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)){
            User user = (User)authentication.getPrincipal();
            if (user != null){
                return userMapper.toDto(user);
            }
        }
        return null;
    }

    public User getCurrentSessionUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)){
            User user = (User)authentication.getPrincipal();
            if (user != null){
                return user;
            }
        }
        return null;
    }

    public List<UserDTO> getUsers(){
        return userMapper.toDtoList(userRepository.findAll());
    }

    public UserDTO getUser(Long id){
        return userMapper.toDto(userRepository.findById(id).orElse(null));
    }

}
