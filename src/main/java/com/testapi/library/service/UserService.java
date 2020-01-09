package com.testapi.library.service;

import com.testapi.library.entity.UserEntity;
import com.testapi.library.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private UserEntity userEntity;

    public String createUser(String userName){
        return userRepo.addUser(userName);
    }

    public Map<String, UserEntity> getUser(){
        return userRepo.getAllUsers();
    }

}
