package com.example.Luana_Nature.service;


import com.example.Luana_Nature.model.Reservation;
import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.repository.ReservationRepository;
import com.example.Luana_Nature.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final static List<Reservation> reservations = new ArrayList<>();

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public void addReservation(String name, String email, String phone, String company, LocalDate arrivalDate,
                               LocalDate departureDate, int numberOfPersons, String accommodationType, String cateringType,
                               String cateringMentions, String drinkType, String message, User user) {

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
        reservation.setReservationUser(user);

        reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservations.removeIf(reservation -> reservation.getReservationId().equals(id));
    }

    public void updateReservation(Reservation oldReservation, Reservation newReservation) {
    newReservation.setReservationId(oldReservation.getReservationId());
    newReservation.setName(oldReservation.getName());
    newReservation.setEmail(oldReservation.getEmail());
    newReservation.setPhone(oldReservation.getPhone());
    newReservation.setCompany(oldReservation.getCompany());
    newReservation.setArrivalDate(oldReservation.getArrivalDate());
    newReservation.setDepartureDate(oldReservation.getDepartureDate());
    newReservation.setNumberOfPersons(oldReservation.getNumberOfPersons());
    newReservation.setAccommodationType(oldReservation.getAccommodationType());
    newReservation.setCateringType(oldReservation.getCateringType());
    newReservation.setCateringMentions(oldReservation.getCateringMentions());
    newReservation.setDrinkType(oldReservation.getDrinkType());
    newReservation.setMessage(oldReservation.getMessage());
    reservationRepository.save(newReservation);
}


public List<Reservation> getReservationsByUser(Long userId) {
    Optional<User> user = userRepository.findById(userId);
    return reservationRepository.findByReservationUser(user);
}


}
