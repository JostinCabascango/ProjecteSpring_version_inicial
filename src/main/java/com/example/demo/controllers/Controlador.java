package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controlador {
    @GetMapping("/")
    public String iniciar() {
        return "login";
    }

    @PostMapping("")
    public String login() {
        return "consulta";
    }

}
