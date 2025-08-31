package com.wipro.usermanagement.service.impl;

import com.wipro.usermanagement.dto.*;
import com.wipro.usermanagement.entity.Role;
import com.wipro.usermanagement.entity.User;
import com.wipro.usermanagement.repository.RoleRepository;
import com.wipro.usermanagement.repository.UserRepository;
import com.wipro.usermanagement.service.UserService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        if (userRepo.findByUsername(dto.getUsername()).isPresent()) {
            throw new NotFoundException("Username already exists: " + dto.getUsername());
        }

        Role role = roleRepo.findById(dto.getRoleId())
                .orElseThrow(() -> new NotFoundException("Role not found with ID " + dto.getRoleId()));

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setName(dto.getName());
        user.setAddress(dto.getAddress());
        user.setPhoneno(dto.getPhoneno());
        user.setEnabled(dto.isEnabled());
        user.setRole(role);

        return mapToResponse(userRepo.save(user));
    }

    @Override
    public UserResponseDTO updateUser(Integer id, UserRequestDTO dto) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID " + id));

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setAddress(dto.getAddress());
        user.setPhoneno(dto.getPhoneno());
        user.setEnabled(dto.isEnabled());

        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        if (dto.getRoleId() != null) {
            Role role = roleRepo.findById(dto.getRoleId())
                    .orElseThrow(() -> new NotFoundException("Role not found with ID " + dto.getRoleId()));
            user.setRole(role);
        }

        return mapToResponse(userRepo.save(user));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepo.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Integer id) {
        return userRepo.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new NotFoundException("User not found with ID " + id));
    }

    @Override
    public void deleteUser(Integer id) {
        if (!userRepo.existsById(id)) {
            throw new NotFoundException("User not found with ID " + id);
        }
        userRepo.deleteById(id);
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO dto) {
        User user = userRepo.findByUsername(dto.getUsername())
                .orElseThrow(() -> new NotFoundException("Invalid username or password"));

        boolean matches = passwordEncoder.matches(dto.getPassword(), user.getPassword());

        LoginResponseDTO response = new LoginResponseDTO();
        response.setSuccess(matches);
        response.setMessage(matches ? "Login successful" : "Invalid username or password");
        return response;
    }

    private UserResponseDTO mapToResponse(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getUid());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setAddress(user.getAddress());
        dto.setPhoneno(user.getPhoneno());
        dto.setEnabled(user.isEnabled());
        dto.setRoleName(user.getRole().getRname());
        return dto;
    }
}
