package main.service.service;
import main.model.Order;
import main.model.Status;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    void save(Order order);

    void setStatus(Long orderId,Status status,Date shipDate) ;

    List<Order> getAll();

    Optional<Order> findOrderByUserId(Long id);

    Optional<Order> findById(Long id);
}
