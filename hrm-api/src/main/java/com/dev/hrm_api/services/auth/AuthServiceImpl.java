package com.dev.hrm_api.services.auth;

import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dev.hrm_api.dtos.auth.request.SignInRequest;
import com.dev.hrm_api.dtos.auth.request.SignUpRequest;
import com.dev.hrm_api.dtos.auth.response.AuthResponse;
import com.dev.hrm_api.repositories.UserRepository;
import com.dev.hrm_api.schema.User;
import com.dev.hrm_api.services.jwt.JwtService;
import com.dev.hrm_api.services.user.UserDetailsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @Override
    public AuthResponse signIn(SignInRequest signInRequest) throws Exception {

        UserDetails userDetails = userDetailsService.loadUserByUsername(signInRequest.getUsername());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));

        return new AuthResponse(jwtService.generateToken(userDetails));

    }

    @Override
    public AuthResponse signUp(SignUpRequest signUpRequest) {
        // TODO: check existing user
        User user = new User();
        // TODO: map signUpDto to User
        user.setUsername(signUpRequest.getUsername());
        user.setUid(UUID.randomUUID());
        user.setPasswordHash(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setEmail(signUpRequest.getEmail());
        user.setPhoneNumber(signUpRequest.getPhoneNumber());
        user.setFullName(signUpRequest.getFullName());
        user.setActive(true);

        userRepository.save(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        return new AuthResponse(jwtService.generateToken(userDetails));

    }

}
