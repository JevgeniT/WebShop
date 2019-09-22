package com.example.myapp.service.impl;

import com.example.myapp.model.Order;
import com.example.myapp.model.Status;
import com.example.myapp.repos.OrderRepository;
import com.example.myapp.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public Optional<Order> findOrderByUserId(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void setStatus(Long orderId ,Status status ,Date shipDate){
        orderRepository.setStatus(orderId,status,shipDate);
    }


}
