package main.service.service;
import main.model.Product;
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
