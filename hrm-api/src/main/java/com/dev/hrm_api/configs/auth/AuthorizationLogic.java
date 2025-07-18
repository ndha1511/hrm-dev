package com.dev.hrm_api.configs.auth;

import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.stereotype.Component;

@Component("authz")
public class AuthorizationLogic {
    public boolean hasAccess(MethodSecurityExpressionOperations operations, String resourceId) {
        return operations.getAuthentication().getAuthorities().stream()
                .anyMatch(auth -> {
                    String role = auth.getAuthority();
                    return role.equals("view:" + resourceId)
                            || role.equals("manage:" + resourceId)
                            || role.equals("admin:" + resourceId)
                            || role.equals("admin:parent");
                });
    }
}
