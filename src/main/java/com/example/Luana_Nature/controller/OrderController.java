package com.example.Luana_Nature.controller;


import com.example.Luana_Nature.model.Order;
import com.example.Luana_Nature.model.Product;
import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.repository.ProductRepository;
import com.example.Luana_Nature.service.MyUserPrincipal;
import com.example.Luana_Nature.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;
    private final ProductRepository productRepository;

    /* Vizualizare comenzi */

    @GetMapping("/orders")
    public String allOrders(Model model){
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }

    /*Adăugare comand*/

    @GetMapping("order")
    public String order(Model model){
        model.addAttribute("order", new Order());
        return "redirect:/store";
    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestParam Long productId, @AuthenticationPrincipal MyUserPrincipal userPrincipal) {
        if (userPrincipal != null) {
            User user = userPrincipal.getUser();
            Product product = productRepository.findById(productId).orElse(null);
            if (product != null) {
                orderService.addOrder(LocalDate.now(), "pending", user, product);
            }
        }
        return "redirect:/store";
    }




}
