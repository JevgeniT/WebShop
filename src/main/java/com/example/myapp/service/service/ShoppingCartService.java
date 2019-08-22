package com.example.myapp.service.service;

import com.example.myapp.exception.NotEnoughFundsException;
import com.example.myapp.exception.NotEnoughInStockException;
import com.example.myapp.model.Order;
import com.example.myapp.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {

    void addProduct(Product product,Integer quantity);

    void removeProduct(Product product);

    void checkout(Order order) throws NotEnoughInStockException, NotEnoughFundsException;

    Map<Product, Integer> getProductsInCart();

    BigDecimal getTotal();
}
