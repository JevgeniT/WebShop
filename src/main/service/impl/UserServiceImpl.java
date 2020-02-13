package main.service.impl;

import main.model.Role;
import main.model.User;
import main.repos.UserRepository;
import main.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final  UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {
        if (userRepository.findByUsername(user.getUsername())==null) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Set<Role> roles = new HashSet<>();
            roles.add(user.getUsername().contains("admin") ? Role.ADMIN : Role.USER);
            user.setRoles(roles);
            user.setBalance(new BigDecimal("50.0"));

        }
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUserId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
