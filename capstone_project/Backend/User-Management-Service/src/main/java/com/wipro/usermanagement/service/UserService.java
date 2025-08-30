package com.wipro.usermanagement.service;

import java.util.List;

import com.wipro.usermanagement.dto.UserDTO;

public interface UserService {
	
    UserDTO createUser(UserDTO userDTO);
    
    UserDTO updateUser(Integer id, UserDTO userDTO);
    
    void deleteUser(Integer id);
    
    UserDTO getUserById(Integer id);
    
    List<UserDTO> getAllUsers();
    
    boolean login(String username, String password);
}
