package com.dev.hrm_api.controllers.v1.testEndpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/sample")
public class SampleEnpoint {

    @GetMapping("/test")
    @PreAuthorize("hasAnyAuthority('edit:payroll')")
    public String getMethodName() {
        return "OK";
    }

}
