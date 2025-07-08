package com.dev.hrm_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String getMethodName() {
        return "hello world changed";
    }

}
