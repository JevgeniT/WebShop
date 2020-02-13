package main.service.service;
import main.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();

    Optional<Product> findById(Long id);

    void save(Product product);

    void delete(Product product);

}