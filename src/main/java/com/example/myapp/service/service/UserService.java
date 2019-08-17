package com.example.myapp.service.service;

import com.example.myapp.model.User;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user);

    void setBalance(Long userId , BigDecimal bigDecimal);

    User findByUsername(String username);

    User findByUserId(Long id);

    List<User> findAll();
}
