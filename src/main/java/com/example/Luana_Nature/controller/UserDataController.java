package com.example.Luana_Nature.controller;

import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.service.MyUserDetailsService;
import com.example.Luana_Nature.service.EmailService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserDataController {

    private final MyUserDetailsService userDataService;
    private final EmailService emailService;

    @GetMapping("/register")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/adduser")
    public String addUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String username,
            @RequestParam String password) {
        userDataService.addUser(name, email, username, password);

        String subject = "User nou";
        String text = "Utilizator nou creat:\nName: " + name + "\nEmail: " + email + "\nUsername: " + username;
        emailService.sendEmail(email, name);

        return "redirect:/index";
    }

    @GetMapping("/signin")
    public String logInForm(Model model) {
        model.addAttribute("user", new User());
        return "signin";
    }

    @PostMapping("/signin")
    public String signIn(@RequestParam String username,
                         @RequestParam String password,
                         Model model) {
        UserDetails userDetails = userDataService.loadUserByUsername(username);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            model.addAttribute("user", userDetails);

        }
        return "index";
    }
}

