package com.dev.hrm_api.dtos.auth.request;

import lombok.Getter;

@Getter
public class SignInRequest {
    private String username;
    private String password;
}
