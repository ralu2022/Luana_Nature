package com.example.Luana_Nature.service;


import com.example.Luana_Nature.model.Reservation;
import com.example.Luana_Nature.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;


    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public void addReservation(String name, String email, String phone, String company, LocalDate arrivalDate,
                               LocalDate departureDate, int numberOfPersons, String accommodationType, String cateringType,
                               String cateringMentions, String drinkType, String activity, String period,String message) {

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
        reservation.setActivity(activity);
        reservation.setPeriod(period);
        reservation.setMessage(message);

        reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(()->new IllegalArgumentException(
                "Rezervarea nu există!"));
        reservationRepository.delete(reservation);
    }

    public List<Map<String, Object>> getReservationCountByType() {
        return reservationRepository.countReservationsByType();
    }


}
