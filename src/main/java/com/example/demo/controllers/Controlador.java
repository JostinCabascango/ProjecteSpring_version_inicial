package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.Usuario;

@Controller
public class Controlador {
    @GetMapping("/")
    public String iniciar(Model model) {
        model.addAttribute("titulo", "FORMULARIO DE ACCESO");
        return "login";
    }

    @PostMapping("")
    public String login(Model model, Usuario usuario) {
        if (usuario.getNombre().equals("edu") && usuario.getPassword().equals("edu")) {
            return "consulta";
        } else {
            return "login";

        }
    }

}
