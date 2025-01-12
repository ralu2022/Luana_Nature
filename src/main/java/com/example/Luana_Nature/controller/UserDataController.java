package com.example.Luana_Nature.controller;

import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.service.EmailService;

import com.example.Luana_Nature.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserDataController {

    private final UserService userService;
    private final EmailService emailService;

    /* Înregistrare user */

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
            @RequestParam String password,
            String role) {
        userService.addUser(name, email, username, password, role);

        String subject = "User nou";
        String text = "Utilizator nou creat:\nName: " + name + "\nEmail: " + email + "\nUsername: " + username;
        emailService.sendEmail(email, name);

        return "redirect:/index";
    }


    /* Logarea unui user */

    @GetMapping("/login")
    public String logInForm(Model model) {
        model.addAttribute("user", new User());
        return "login";}

    @PostMapping("/login")
    public String signIn(@RequestParam String username,
                         @RequestParam String password,
                         Model model) {
        try{
            User user = userService.findByUserName(username);

            if(!password.equals(user.getPassword())){
                model.addAttribute("error", "Username sau parola sunt greșite!");
                return "index";
            }
            return "redirect:/mainpageuser";

        }catch(Exception e){
            model.addAttribute("error", "Utilizatorul nu exista!");
            return "index";
        }
    }

    @GetMapping("/loginadmin")
    public String logInFormAdmin(Model model) {
        model.addAttribute("user", new User());
        return "loginadmin";
    }


    @PostMapping("/loginadmin")
    public String signInAdmin(@RequestParam String username,
                         @RequestParam String password,
                         Model model) {
        if ("admin".equals(username) && "admin".equals(password)) {
            return "mainpageadmin";
        } else {
            model.addAttribute("error", "Username sau parola sunt greșite!");  // Set error message
            return "index";
        }
    }


}


