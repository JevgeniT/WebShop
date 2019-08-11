package com.example.myapp.service.service;

import com.example.myapp.model.Order;
import com.example.myapp.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout(Order order);

    BigDecimal getTotal();
}
