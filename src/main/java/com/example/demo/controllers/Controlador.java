package com.example.demo.controllers;

import java.util.ArrayList;
import com.example.demo.service.BaseDatos3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.bean.Usuario;
import com.example.demo.bean.Libro;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class Controlador {
    @Autowired()
    BaseDatos3Service bd;
    Usuario usuario;

    @GetMapping("/")
    public String iniciar(Model model) {
        model.addAttribute("titulo", "FORMULARIO DE ACCESO");
        return "login";
    }

    @PostMapping("/")
    public String login(Model model, Usuario usuario) {
        if (usuario != null && usuario.getNombre() != null && usuario.getPassword() != null) {
            if (usuario.getNombre().equals("edu") && usuario.getPassword().equals("edu")) {
                ArrayList<Libro> libros = bd.getLibros();
                model.addAttribute("usuario", usuario);
                this.usuario = usuario;
                model.addAttribute("libros", libros);

                return "consulta";
            }
        }

        // Si el usuario es nulo o las credenciales no coinciden, redirige a la página de login.
        return "login";
    }

    @PostMapping("/insertar")
    public String insertar(Libro libro, Model model) {
        bd.insertar(libro);
        ArrayList<Libro> libros = bd.getLibros();
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("libros", libros);
        model.addAttribute("boton", "Insertar Libro");
        model.addAttribute("action", "/insertar");
        model.addAttribute("libro", null);
        return "consulta";
    }

    @GetMapping("borrado/{id}")
    public String borrar(@PathVariable int id, Model model) {
        bd.borrar(id);
        ArrayList<Libro> libros = bd.getLibros();
        model.addAttribute("libros", libros);
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("boton", "Insertar Libro");
        model.addAttribute("action", "/insertar");
        return "consulta";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model) {
        Libro libro = bd.getLibro(id);
        ArrayList<Libro> libros = bd.getLibros();
        model.addAttribute("libros", libros);
        model.addAttribute("libro", libro);
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("boton", "Actualizar Libro");
        model.addAttribute("action", "/modificar");
        return "consulta";
    }

    @PostMapping("/modificar")
    public String modificar2(Libro libro, Model model) {
        bd.modificar(libro);
        ArrayList<Libro> libros = bd.getLibros();
        model.addAttribute("libros", libros);
        model.addAttribute("libro", null);
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("boton", "Insertar Libro");
        model.addAttribute("action", "/insertar");
        return "consulta";
    }

}
