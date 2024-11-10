package com.example.Luana_Nature.controller;

import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.service.UserDataService;
import com.example.Luana_Nature.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserDataController {

    final UserDataService userDataService;
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
}
