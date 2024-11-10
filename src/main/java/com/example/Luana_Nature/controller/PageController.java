package com.example.Luana_Nature.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/companii")
    public String companii() {
        return "companies";
    }

    @GetMapping("/individual")
    public String individual() {
        return "individuals";
    }

    @GetMapping("/kids")
    public String kids() {
        return "kidsarea";
    }

    @GetMapping("/store")
    public String store() {
        return "store";
    }

    @GetMapping("/reservation")
    public String rezervare() {
        return "reservation";
    }

    @GetMapping("/aboutus")
    public String aboutus() {
        return "aboutus";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
