package com.testapi.library.controller;

import com.testapi.library.entity.UserEntity;
import com.testapi.library.requestobject.UserObject;
import com.testapi.library.response.Response;
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
    String message="";
    String response="";
    int status =0;

    @PostMapping(value = "api/v1/user")
    public Response createUser(@RequestBody UserObject userObject) {
        try {
            String userName = userObject.getUserName();
            response = userService.createUser(userName);
            message = "Successfully created user";
            status = 1;
        } catch (Exception e) {
            message = "Error while creating USER";
        }
        return new Response(status, message, response);

    }

    @GetMapping(value = "api/v1/user")
    public Map<String, UserEntity> getUser(){
        return userService.getUser();
    }
}
