package org.example.helloshoesbackend.service;

import org.example.helloshoesbackend.dto.UserDTO;

import java.util.List;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);

    List<UserDTO> getAllUsers();
}
