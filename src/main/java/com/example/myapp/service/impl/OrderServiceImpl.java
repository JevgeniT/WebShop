package com.example.myapp.service.impl;

import com.example.myapp.model.Order;
import com.example.myapp.model.Status;
import com.example.myapp.repos.OrderRepository;
import com.example.myapp.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(Order order) {
       orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findOrderByUser_Id(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void setStatus(Long orderId ,Status status ,LocalDateTime shipDate){
        orderRepository.setStatus(orderId,status,shipDate);
    }


}
