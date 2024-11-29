package com.example.Luana_Nature.controller;


import com.example.Luana_Nature.model.Product;
import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.service.MyUserDetailsService;
import com.example.Luana_Nature.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;
    private final MyUserDetailsService userDetailsService;

    @GetMapping("/store")
    public String listAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "store";
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        List<Product> products = productService.getAllProducts();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = (User) userDetailsService.loadUserByUsername(username);

        model.addAttribute("products", products);
        model.addAttribute("user", user);
        return "store";
    }

}
