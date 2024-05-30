package org.example.helloshoesbackend.controller;

import org.example.helloshoesbackend.service.UserService;
import org.example.helloshoesbackend.util.JwtUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
}
