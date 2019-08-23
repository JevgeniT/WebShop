package com.example.myapp.service.impl;

import com.example.myapp.exception.NotEnoughFundsException;
import com.example.myapp.exception.NotEnoughInStockException;
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

import javax.persistence.ManyToOne;
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
    public void addProduct(Product product, Integer quantity) {
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + quantity);
        } else {
            products.put(product, quantity);
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
    public void checkout(Order order) throws NotEnoughInStockException,NotEnoughFundsException {
        for (Map.Entry<Product,Integer> entry:products.entrySet()){
          Product  product = productRepository.getOne(entry.getKey().getId());
          if (product.getQuantity() < entry.getValue()) {
              entry.getKey().setQuantity(product.getQuantity() - entry.getValue());
              throw new NotEnoughInStockException(product);
          }else if (order.getUser().getBalance().compareTo(getTotal())<0){
              throw new NotEnoughFundsException(order.getUser());
          }
            product.setQuantity(product.getQuantity() - entry.getValue());
            productRepository.save(product);
          }
        products.clear();
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
