package com.example.myapp.repos;
import com.example.myapp.model.Order;
import com.example.myapp.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;


public interface OrderRepository extends JpaRepository<Order, Long>{

    @Transactional
    @Modifying
    @Query("update Order o set o.status = ?2, o.shipDate= ?3 where o.id = ?1")
    void setStatus(Long orderId,Status status,Date shipDate);
}
