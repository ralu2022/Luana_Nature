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
    private int id;
    String name;
    String email;
    String phone;
    String company;
    LocalDate arrivalDate;
    LocalDate departureDate;
    Integer numberOfPersons;
    String acomodation;
    String catering;
    String cateringMentions;
    String drinking;
    String message;
}
