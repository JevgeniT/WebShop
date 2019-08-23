package com.example.myapp.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;



@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "products")
public class  Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "quantity")
    private Integer quantity;

    @NonNull
    @Column(name = "price")
    private BigDecimal price;


//
//    public Product(String name ,Integer quantity ,BigDecimal price) {
//        this.name = name;
//        this.quantity = quantity;
//        this.price = price;
//    }
//    public Product() {
//    }
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Product product = (Product) o;
//
//        return id.equals(product.id);
//    }
//    @Override
//    public int hashCode() {
//        return id.hashCode();
//    }
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", quantity=" + quantity +
//                ", price=" + price +
//                '}';
//    }
}