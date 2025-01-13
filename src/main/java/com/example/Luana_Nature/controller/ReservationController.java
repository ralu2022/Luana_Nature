package com.example.Luana_Nature.controller;

import com.example.Luana_Nature.model.Reservation;
import com.example.Luana_Nature.service.EmailService;
import com.example.Luana_Nature.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/reservations")
@RequiredArgsConstructor

public class ReservationController {

    private final ReservationService reservationService;
    private final EmailService emailService;


    /* Vizualizare rezervări - toate */

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
                                 @RequestParam String activity,
                                 @RequestParam String period,
                                 @RequestParam String message) {


        reservationService.addReservation(name, email,phone,company,arrivalDate,departureDate,numberOfPersons,
                accommodationType,cateringType,cateringMentions,drinkType,activity,period,message);
        return "redirect:/reservations/reservations";
    }

  @GetMapping("/delete/{reservationId}")
  public String deleteReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.deleteReservation(reservationId);
        return "redirect:/reservations/reservations";
  }

    @GetMapping("/api/count-by-type")
    @ResponseBody
    public List<Map<String, Object>> getCountByType() {
        return reservationService.getReservationCountByType();
    }

    @GetMapping("/chart")
    public String showReservationChart(Model model) {
        List<Map<String, Object>> reservationData = reservationService.getReservationCountByType();
        model.addAttribute("reservationData", reservationData);
        return "redirect:/mainpage";
    }


}
