/*package com.example.Luana_Nature.util.notinuse.order;

import com.example.Luana_Nature.model.Product;
import com.example.Luana_Nature.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    private LocalDate orderDate;
    private String status;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> orderProducts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User orderUser;

    private double totalPrice;
}
*/