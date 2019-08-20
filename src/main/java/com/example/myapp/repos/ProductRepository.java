package com.example.myapp.repos;

import com.example.myapp.model.Product;
import com.example.myapp.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface ProductRepository extends JpaRepository<Product, Long>{
//    @Transactional
//    @Modifying
//    @Query("update Product p set o.status = ?2, o.shipDate= ?3 where o.id = ?1")
//    void updateOrder(Long orderId,Status status,LocalDateTime shipDate);
}
