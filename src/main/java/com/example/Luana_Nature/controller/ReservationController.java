package com.example.Luana_Nature.controller;


import com.example.Luana_Nature.model.Reservation;
import com.example.Luana_Nature.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/reservations")
@RequiredArgsConstructor

public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/reservation")
    public String reservation(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation";
    }

    @PostMapping("/addReservation")
    public String addReservation(@RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String phone,
                                 @RequestParam String company,
                                 @RequestParam LocalDate arrivalDate,
                                 @RequestParam LocalDate departureDate,
                                 @RequestParam int numberOfPersons,
                                 @RequestParam String accommodationType,
                                 @RequestParam String cateringType,
                                 @RequestParam String cateringMentions,
                                 @RequestParam String drinkType,
                                 @RequestParam String message,
                                 Model model) {

        if (arrivalDate.isAfter(departureDate)) {
            model.addAttribute("arrivalDateError", "Arrival date cannot be after departure date.");
            return "reservation";
        }

        if (departureDate.isBefore(arrivalDate)) {
            model.addAttribute("departureDateError", "Departure date cannot be before arrival date.");
            return "reservation";
        }

        reservationService.addReservation(name, email, phone, company, arrivalDate, departureDate, numberOfPersons,
                accommodationType, cateringType, cateringMentions, drinkType, message);
        return "redirect:/index";
    }
}
