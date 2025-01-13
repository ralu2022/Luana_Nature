package com.example.Luana_Nature.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@Table(name = "reservations")
@NoArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    private String name;
    private String email;
    private String phone;
    private String company;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private int numberOfPersons;
    private String accommodationType;
    private String cateringType;
    private String cateringMentions;
    private String drinkType;
    private String message;
    private String activity;
    private String period;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User reservationUser;

}
