package com.example.Luana_Nature.controller;


import com.example.Luana_Nature.model.Cart;
import com.example.Luana_Nature.model.Product;
import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.repository.CartRepository;
import com.example.Luana_Nature.repository.UserRepository;
import com.example.Luana_Nature.service.CartService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor

public class CartController {

    private final CartService cartService;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @GetMapping("/viewcart")
    public String viewCart(@RequestParam("userId") Long userId, Model model) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<Cart> cartItems = cartRepository.findByUser(user);
        model.addAttribute("cartItems", cartItems);
        return "store";
    }

    @PostMapping("/addtocart")
    public String addCart(@RequestParam User user,
                          @RequestParam Product product,
                          @RequestParam int quantity) {
            cartService.addInCart(user, product,quantity);

            return "redirect:/store";
    }
}