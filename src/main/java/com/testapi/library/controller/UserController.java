package com.testapi.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping(value = "api/v1/user")
    public String createUser() {
        return "User Created";
    }
}
