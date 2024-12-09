package com.example.Luana_Nature.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long orderId;

    LocalDate orderDate;
    String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User orderUser;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
