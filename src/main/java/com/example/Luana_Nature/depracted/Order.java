/*package com.example.Luana_Nature.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "orders")
@NoArgsConstructor

public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String customerName;
    private Long totalAmount;
    private LocalDate creationDate;
    private String address;
    private String orderStatus;
    private String notes;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> products = new ArrayList<>();

    public Order(String customerName, Long totalAmount, LocalDate creationDate, String address, String orderStatus, String notes, User user, List<Product> products) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.creationDate = creationDate;
        this.address = address;
        this.orderStatus = orderStatus;
        this.notes = notes;
        this.user = user;
        this.products = products;
    }
}*/