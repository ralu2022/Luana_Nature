package com.example.Luana_Nature.controller;


import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.repository.UserRepository;
import com.example.Luana_Nature.service.MyUserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/mainpage")
    public String mainpage() {
        return "mainpage";
    }

    @GetMapping("/welcome")
    public String welcome(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("username", username);
        return "welcome";
    }

    @GetMapping("/companies")
    public String companii() {
        return "companies";
    }

    @GetMapping("/individuals")
    public String individual() {
        return "individuals";
    }

    @GetMapping("/kids")
    public String kids() {
        return "kids";
    }

    @GetMapping("/aboutus")
    public String aboutus() {
        return "aboutus";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/termsofservice")
    public String terms() {
        return "termsofservice";
    }

    @GetMapping("/politics")
    public String politics() {
        return "politics";
    }

    @GetMapping("/imprint")
    public String imprint() {
        return "imprint";
    }
}
