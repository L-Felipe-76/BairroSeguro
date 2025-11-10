package com.example.BairroSeguro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bairroseguro/")
public class HomeController {

    @GetMapping("login/")
    public String home(){
        return "home";
    }
}
