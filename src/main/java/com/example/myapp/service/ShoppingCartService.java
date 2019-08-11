package com.example.myapp.service;

import com.example.myapp.model.Product;

import java.util.Map;

public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout();

    Double getTotal();
}
