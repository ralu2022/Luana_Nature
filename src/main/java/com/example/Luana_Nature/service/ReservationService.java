package com.example.Luana_Nature.service;


import com.example.Luana_Nature.model.Product;
import com.example.Luana_Nature.model.Reservation;
import com.example.Luana_Nature.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public void addReservation(String name, String email, String phone, String company, LocalDate arrivalDate, LocalDate departureDate,
            int numberOfPersons, String accommodationType, String cateringType, String cateringMentions, String drinkType, String message)
    {
            Reservation reservation = new Reservation();
            reservation.setName(name);
            reservation.setEmail(email);
            reservation.setPhone(phone);
            reservation.setCompany(company);
            reservation.setArrivalDate(arrivalDate);
            reservation.setDepartureDate(departureDate);
            reservation.setNumberOfPersons(numberOfPersons);
            reservation.setAccommodationType(accommodationType);
            reservation.setCateringType(cateringType);
            reservation.setCateringMentions(cateringMentions);
            reservation.setDrinkType(drinkType);
            reservation.setMessage(message);

            reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
