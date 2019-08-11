package com.example.myapp.service;

import com.example.myapp.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
