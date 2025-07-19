package com.dev.hrm_api.dtos.user;

import com.dev.hrm_api.models.enums.PermEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPermDto {
    private String appCode;
    private PermEnum perm;

}
