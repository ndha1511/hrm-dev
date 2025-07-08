package com.dev.hrm_api.dtos.user;

import com.dev.hrm_api.schema.enums.PermEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPermDto {
    private String username;
    private String password;
    private Integer appCode;
    private PermEnum permType;
}
