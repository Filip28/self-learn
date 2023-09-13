package com.app.selflearn.service;


import com.app.selflearn.security.JwtAuthenticationResponse;
import com.app.selflearn.security.SignInRequest;
import com.app.selflearn.security.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequest request);

    JwtAuthenticationResponse signIn(SignInRequest request);
}
