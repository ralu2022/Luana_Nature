package com.example.Luana_Nature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/loginadmin")
    public String loginadmin() {
        return "loginadmin";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/mainpage")
    public String mainpage() {
        return "mainpage";
    }

    @GetMapping("/mainpageuser")
    public String mainpageuser() {
        return "mainpageuser";
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

    @GetMapping("/catering")
    public String catering() {
        return "catering";
    }

    @GetMapping("/cateringvegan")
    public String cateringvegan() {
        return "cateringvegan";
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
