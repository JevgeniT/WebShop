package main.service.impl;
import main.model.*;
import main.repos.ProductRepository;
import main.service.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final UserService userService;
    private final PrincipalService principalService;
    private Map<Product, Integer> products = new HashMap<>();
    private final ProductRepository productRepository;
    private final OrderService orderService;

    @Override
    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            products.replace(product ,products.get(product) + 1);
        } else {
            products.put(product ,1);
        }
    }

    @Override
    public void removeProduct(Product product ) { products.remove(product); }


    @Override
    public void setProductQuantity(Product product ,Integer quantity) {
        if (products.containsKey(product)) {
            if (quantity >0){
                products.replace(product, quantity);
            }else{
                products.remove(product);
            }
        }
    }

    @Override
    public Map<Product, Integer> getProductsInCart() { return products; }

    @Override
    public void checkout() {
        User user = userService.findByUsername(principalService.getPrincipal());
        if (user.getBalance().compareTo(getTotal())<0 ){
            throw new IllegalArgumentException("Not enough balance.");
        }

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = productRepository.getOne(entry.getKey().getId());

            if (product.getQuantity() < entry.getValue()) {
                entry.getKey().setQuantity(product.getQuantity() - entry.getValue());
                throw new IllegalArgumentException(product.getName() + " is out of stock.");
            }
            product.setQuantity(product.getQuantity() - entry.getValue());
            productRepository.save(product);
        }
        user.setBalance(user.getBalance().subtract(getTotal()));
        userService.save(user);
        orderService.save(new Order(getTotal(),user,Status.Submitted));
        products.clear();
    }

    @Override
    public BigDecimal getTotal() {
        return products.entrySet().stream()
                                .map(entry -> entry.getKey().getPrice()
                                .multiply(BigDecimal.valueOf(entry.getValue())))
                                .reduce(BigDecimal::add)
                                .orElse(BigDecimal.ZERO);
    }
}
