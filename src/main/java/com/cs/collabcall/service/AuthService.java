package com.cs.collabcall.service;

import com.cs.collabcall.dto.UserResponse;
import com.cs.collabcall.entity.User;
import com.cs.collabcall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public UserResponse register(User user) {
        UserService userService = new UserService(userRepository);
    }
}
