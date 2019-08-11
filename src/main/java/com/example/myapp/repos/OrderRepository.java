package com.example.myapp.repos;

import com.example.myapp.model.Order;
import com.example.myapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{

//    Product getOne(String name);
}
