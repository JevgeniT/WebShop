package main.service.service;

import main.model.User;
import java.util.List;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    User findByUserId(Long id);

    List<User> findAll();
}
