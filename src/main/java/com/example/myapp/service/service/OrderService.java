package com.example.myapp.service.service;

import com.example.myapp.model.Order;
import com.example.myapp.model.Product;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    void save(Order order);
    List<Order> getAll();

    Optional<Order> findById(Long id);
}
