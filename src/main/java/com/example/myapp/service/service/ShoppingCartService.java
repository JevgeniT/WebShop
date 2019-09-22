package com.example.myapp.service.service;
import com.example.myapp.model.Product;
import com.example.myapp.model.User;
import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    void setProductQuantity(Product product, Integer quantity);

    void checkout();

    Map<Product, Integer> getProductsInCart();

    BigDecimal getTotal();
}
