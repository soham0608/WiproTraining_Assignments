package com.wipro.usermanagement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wipro.usermanagement.dto.RoleDTO;
import com.wipro.usermanagement.dto.UserDTO;
import com.wipro.usermanagement.entity.Role;
import com.wipro.usermanagement.entity.User;
import com.wipro.usermanagement.repository.RoleRepository;
import com.wipro.usermanagement.repository.UserRepository;
import com.wipro.usermanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    public UserServiceImpl(UserRepository userRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public UserDTO createUser(UserDTO userDto) 
    {
        User user = mapToEntity(userDto);
        User savedUser = userRepo.save(user);
        return mapToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Integer id, UserDTO userDto) 
    {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());

            if (userDto.getRole() != null) {
                Role role = roleRepo.findById(userDto.getRole().getRid())
                                    .orElseThrow(() -> new RuntimeException("Role not found"));
                user.setRole(role);
            }

            User updatedUser = userRepo.save(user);
            return mapToDTO(updatedUser);
        }
        throw new RuntimeException("User not found with id: " + id);
    }

    @Override
    public void deleteUser(Integer id) 
    {
        userRepo.deleteById(id);
    }

    @Override
    public UserDTO getUserById(Integer id) 
    {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return mapToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() 
    {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean login(String username, String password) 
    {
        Optional<User> user = userRepo.findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }

    private UserDTO mapToDTO(User user) {
        RoleDTO roleDto = null;
        if (user.getRole() != null) {
            roleDto = new RoleDTO(user.getRole().getRid(), user.getRole().getRname());
        }

        return new UserDTO(
                user.getUid(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getName(),
                user.getAddress(),
                user.getPhoneno(),
                user.isEnabled(),
                roleDto
        );
    }

    private User mapToEntity(UserDTO userDto) {
        Role role = null;
        if (userDto.getRole() != null) {
            role = roleRepo.findById(userDto.getRole().getRid())
                           .orElseThrow(() -> new RuntimeException("Role not found"));
        }

        User user = new User();
        user.setUid(userDto.getUid());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setPhoneno(userDto.getPhoneno());
        user.setEnabled(userDto.isEnabled());
        user.setRole(role);

        return user;
    }
}
