package com.example.Luana_Nature.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private final JavaMailSender notification;


    public EmailService(JavaMailSender notification) {
        this.notification = notification;
    }

    public void sendEmail(String userEmail, String userName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setSubject("Success");
        message.setText("Salut " + userName + ",\n\n" + "Multumim ca te-ai inregistrat pe site-ul nostru!" + "Cu stima, \n" + "Echipa Luana Nature");
        message.setFrom("raluca.chitu2022@gmail.com");

        try {
            notification.send(message);
            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}
