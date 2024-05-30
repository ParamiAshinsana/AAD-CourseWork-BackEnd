package org.example.helloshoesbackend.service;

import org.example.helloshoesbackend.dto.UserDTO;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);
}
