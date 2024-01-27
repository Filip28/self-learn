package com.app.selflearn.service.impl;

import com.app.selflearn.repository.UserRepository;
import com.app.selflearn.model.AuthUser;
import com.app.selflearn.model.Role;
import com.app.selflearn.security.JwtAuthenticationResponse;
import com.app.selflearn.security.SignInRequest;
import com.app.selflearn.security.SignUpRequest;
import com.app.selflearn.service.AuthenticationService;
import com.app.selflearn.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        userRepository.findByEmail(request.getEmail())
                .stream()
                .findAny()
                .ifPresent(_ -> {
                    throw new ResponseStatusException(HttpStatus.CONFLICT,"User with this email already exists");
                });
        AuthUser user = AuthUser.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse
                .builder()
                .token(jwt)
                .build();
    }
}
