package com.example.myapp.repos;

import com.example.myapp.model.Product;
import com.example.myapp.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

//     void update(Product product);
}
