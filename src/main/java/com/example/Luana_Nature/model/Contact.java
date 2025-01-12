package com.example.Luana_Nature.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact")

public class Contact {
    @Id
    @Column(name="contact_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private String name;
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User contactUser;

}
