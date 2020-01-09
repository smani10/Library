package com.testapi.library.controller;

import com.testapi.library.entity.UserEntity;
import com.testapi.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "api/v1/user")
    public String createUser(@RequestBody UserEntity user) {
        String userName = user.getUserName();
        userService.createUser(userName);
        String message="User Created successfully";
        return message;
    }

    @GetMapping(value = "api/v1/getUser")
    public Map<String, UserEntity> getUser(){
        return userService.getUser();
    }
}
