package com.example.myapp.service.impl;

import com.example.myapp.model.Order;
import com.example.myapp.model.Product;
import com.example.myapp.repos.OrderRepository;
import com.example.myapp.repos.ProductRepository;
import com.example.myapp.service.service.OrderService;
import com.example.myapp.service.service.PrincipalService;
import com.example.myapp.service.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {


    private final ProductRepository productRepository;

    private Map<Product, Integer> products = new HashMap<>();

    @Autowired
    private OrderService orderService;

    @Autowired
    public ShoppingCartServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }

    @Override
    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
//            if (products.get(product) > 1)
//                products.replace(product, products.get(product) - 1);
//            else if (products.get(product) == 1) {
                products.remove(product);
//            }
        }
    }

    @Override
    public Map<Product, Integer> getProductsInCart() {
        return products;
    }

    @Override
    public void checkout(Order order) {
       orderService.save(order);
    }

    @Override
    public BigDecimal getTotal() {
        return products.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
