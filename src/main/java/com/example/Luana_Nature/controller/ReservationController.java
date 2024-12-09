package com.example.Luana_Nature.controller;


import com.example.Luana_Nature.model.Reservation;
import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.repository.ReservationRepository;
import com.example.Luana_Nature.repository.UserRepository;
import com.example.Luana_Nature.service.EmailService;
import com.example.Luana_Nature.service.MyUserDetailsService;
import com.example.Luana_Nature.service.MyUserPrincipal;
import com.example.Luana_Nature.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;


@Controller
@RequestMapping("/reservations")
@RequiredArgsConstructor

public class ReservationController {

    private final ReservationService reservationService;
    private final EmailService emailService;
    private final ReservationRepository reservationRepository;

    /* Vizualizare rezervări */

    @GetMapping("/reservations")
    public String allReservations(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }


    /* Adăugare rezervare */

    @GetMapping("/reservation")
    public String reservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservationform";
    }

    @PostMapping("/addReservation")
    public String addReservation(@RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String phone,
                                 @RequestParam String company,
                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate arrivalDate,
                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate,
                                 @RequestParam int numberOfPersons,
                                 @RequestParam String accommodationType,
                                 @RequestParam String cateringType,
                                 @RequestParam String cateringMentions,
                                 @RequestParam String drinkType,
                                 @RequestParam String message,
                                 @AuthenticationPrincipal MyUserPrincipal userPrincipal) {
        User user = null;
        if(userPrincipal != null) {
            user = userPrincipal.getUser();
        }
        reservationService.addReservation(name,email,phone,company,arrivalDate,departureDate,numberOfPersons,
                accommodationType,cateringType,cateringMentions,drinkType,message,user);

        String subject = "Rezervarea dvs.:";
        String text = "Comandă nouă creată:\nName: " + name + "\nEmail: " + email;
        emailService.sendReservationEmail(email, name);


        return "redirect:/mainpage";
    }



  @GetMapping("/delete/{reservationId}")
  public String deleteReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.deleteReservation(reservationId);
        return "redirect:/reservations/reservations";
  }

}
