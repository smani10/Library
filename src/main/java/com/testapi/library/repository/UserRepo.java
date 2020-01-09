package com.testapi.library.repository;

import com.testapi.library.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserRepo {
    private Map<String, UserEntity> users = new HashMap<>();

    public String addUser(String userName) {
        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = new UserEntity(uuid.toString(), userName);
        users.put(uuid.toString(), userEntity);
        return uuid.toString();
    }

    public Map<String, UserEntity> getAllUsers(){
        return users;
    }
}
