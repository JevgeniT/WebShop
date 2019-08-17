package com.example.myapp.repos;

import com.example.myapp.model.Order;
import com.example.myapp.model.Product;
import com.example.myapp.model.Status;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long>{

    @Transactional
    @Modifying
    @Query("update Order o set o.status = ?2 where o.id = ?1")
    void setStatus(Long orderId, Status status);
}
