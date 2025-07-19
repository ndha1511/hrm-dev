package com.dev.hrm_api.services.auth;

import com.dev.hrm_api.dtos.auth.request.SignInRequest;
import com.dev.hrm_api.dtos.auth.request.SignUpRequest;
import com.dev.hrm_api.dtos.auth.response.AuthResponse;

public interface AuthService {
    /**
     * Generates a JWT token for the given login credentials.
     *
     * @param signInRequest the login credentials
     * @return a TokenDto containing the generated JWT token
     */
    AuthResponse signIn(SignInRequest signInRequest) throws Exception;

    /**
     * Registers a new user and generates a JWT token for the new user.
     *
     * @param signUpRequest the sign-up details
     * @return a TokenDto containing the generated JWT token
     */
    AuthResponse signUp(SignUpRequest signUpRequest) throws Exception;
}
