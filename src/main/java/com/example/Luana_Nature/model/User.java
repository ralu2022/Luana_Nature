package com.example.Luana_Nature.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;
    private String username;
    private String password;
    private String role;

    @OneToMany(mappedBy = "reservationUser")
    private List<Reservation> reservationList;

    @OneToMany(mappedBy = "reviewUser")
    private List<Review> reviewList;

    @OneToMany(mappedBy = "contactUser")
    private List<Contact> contactList;

    @OneToMany(mappedBy = "productUser")
    private List<Product> productList;

}