package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.bean.Usuario;
import com.example.demo.bean.Libro;

import repository.BaseDatos;

@Controller
public class Controlador {
    BaseDatos bd = new BaseDatos();

    @GetMapping("/")
    public String iniciar(Model model) {
        model.addAttribute("titulo", "FORMULARIO DE ACCESO");
        return "login";
    }

    @PostMapping("/")
    public String login(Model model, Usuario usuario) {
        if (usuario.getNombre().equals("edu") && usuario.getPassword().equals("edu")) {
            ArrayList<Libro> libros = bd.getLibros();
            model.addAttribute("usuario", usuario);
            model.addAttribute("libros", libros);
            return "consulta";
        } else {
            return "login";

        }
    }

}
