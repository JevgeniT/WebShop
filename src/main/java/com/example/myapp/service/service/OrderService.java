package com.example.myapp.service.service;

import com.example.myapp.model.Order;
import com.example.myapp.model.Status;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    void save(Order order);

    void setStatus(Long orderId,Status status,LocalDateTime shipDate) ;

    List<Order> getAll();

    Optional<Order> findOrderByUser_Id(Long id);

    Optional<Order> findById(Long id);
}
