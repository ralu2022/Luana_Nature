package com.example.Luana_Nature.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long productId;
    private String name;
    private int price;
    private int stock;
    private String description;
    private String category;

    @OneToMany(mappedBy = "product")
    private List<Order> orderList;

}