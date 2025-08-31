package com.wipro.usermanagement.service;

import com.wipro.usermanagement.dto.*;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO dto);

    UserResponseDTO updateUser(Integer id, UserRequestDTO dto);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Integer id);

    void deleteUser(Integer id);

    LoginResponseDTO login(LoginRequestDTO dto);
}
