package org.example.helloshoesbackend.service.impl;

import org.example.helloshoesbackend.dto.UserDTO;
import org.example.helloshoesbackend.repository.UserRepository;
import org.example.helloshoesbackend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public int saveUser(UserDTO userDTO) {
        return 0;
    }

    @Override
    public UserDTO searchUser(String username) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
