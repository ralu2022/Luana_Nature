package com.example.Luana_Nature.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reviews")

public class Review {
    @Id
    @Column(name="review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private int rating;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User reviewUser;

}
