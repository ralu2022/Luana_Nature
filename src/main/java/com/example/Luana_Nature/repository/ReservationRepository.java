package com.example.Luana_Nature.repository;


import com.example.Luana_Nature.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.Luana_Nature.model.User;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

   Optional<Reservation> findByReservationId(Long reservationId);
   List<Reservation> findByReservationUser(Optional<User> reservationUser);
}