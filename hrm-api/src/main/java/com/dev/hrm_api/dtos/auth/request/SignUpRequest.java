package com.dev.hrm_api.dtos.auth.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignUpRequest {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String phoneNumber;

}
