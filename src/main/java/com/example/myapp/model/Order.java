package com.example.myapp.model;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "order_date")
    private LocalDateTime orderDate = LocalDateTime.now();

    @NonNull
    @Column(name = "total_price")
    private BigDecimal totalPrice;


    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    @NonNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status ;


    @Column(name = "ship_date")
    private  LocalDateTime shipDate;

}
