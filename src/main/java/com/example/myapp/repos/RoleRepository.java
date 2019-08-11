package com.example.myapp.repos;

import com.example.myapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long>{
}