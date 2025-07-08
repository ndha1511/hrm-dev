package com.dev.hrm_api.api.v1.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.hrm_api.dtos.auth.request.SignInRequest;
import com.dev.hrm_api.dtos.auth.request.SignUpRequest;
import com.dev.hrm_api.dtos.auth.response.AuthResponse;
import com.dev.hrm_api.services.auth.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("${apiPrefix}/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signIn")
    public AuthResponse signIn(@RequestBody SignInRequest signInRequest) throws Exception {
        return authService.signIn(signInRequest);
    }

    // Test CI check
    @PostMapping("/signUp")
    public AuthResponse signUp(@RequestBody SignUpRequest signUpRequest) throws Exception {
        return authService.signUp(signUpRequest);
    }

}
