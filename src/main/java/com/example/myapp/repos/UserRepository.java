package com.example.myapp.repos;
import com.example.myapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
