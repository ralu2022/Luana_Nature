package com.example.Luana_Nature.controller;


import com.example.Luana_Nature.model.Contact;
import com.example.Luana_Nature.service.ContactService;
import com.example.Luana_Nature.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contactMessages")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;
    private final EmailService emailService;

    /* Vizualizare mesaje primite */

    @GetMapping("/allcontactMessages")
    public String allContactMessages(Model model) {
        model.addAttribute("contactMessages", contactService.getAllContactMessages());
        return "contactMessages";
    }

    /* Adăugare mesaj */

    @GetMapping("/contactMessage")
    public String contactMessage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/addContactMessage")
    public String addContactMessage(@RequestParam String name,
                                    @RequestParam String message) {
        contactService.addContactmessage(name, message);

        String subject = "Mesaj nou";
        String text = "Aveți un nou mesaj de la " + name + ": " + "\n" + message;
        String adminEmail = "luananature2024@gmail.com";
        emailService.sendAdminEmail(adminEmail, subject, text);

        return "redirect:/contact";
    }

}
