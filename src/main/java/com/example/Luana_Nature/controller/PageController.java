package com.example.Luana_Nature.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/index")
    public String index() {
        return "index";
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
        return "kidsarea";
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
