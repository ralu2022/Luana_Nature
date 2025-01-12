package com.example.Luana_Nature.repository;


import com.example.Luana_Nature.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.Luana_Nature.model.User;

import java.util.Map;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

   @Query("SELECT r.accommodationType AS type, COUNT(r) AS count FROM Reservation r GROUP BY r.accommodationType")
   List<Map<String, Object>> countReservationsByType();


}