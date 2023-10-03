package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Iterator;

import com.example.demo.bean.Libro;

public class BaseDatos {
    ArrayList<Libro> libros = new ArrayList<Libro>();

    public BaseDatos() {
        libros.add(new Libro(1, "Cien años de soledad", "Gabriel García Márquez", "Editorial Sudamericana", "1967",
                "Realismo mágico"));
        libros.add(new Libro(2, "1984", "George Orwell", "Editorial Secker and Warburg", "1949", "Ciencia ficción"));
        libros.add(new Libro(3, "El Hobbit", "J.R.R. Tolkien", "Editorial Allen & Unwin", "1937", "Fantasía"));
        libros.add(new Libro(4, "Matar un ruiseñor", "Harper Lee", "Editorial J.B. Lippincott & Co.", "1960",
                "Novela negra"));
        libros.add(new Libro(5, "Don Quijote de la Mancha", "Miguel de Cervantes", "Editorial Francisco de Robles",
                "1605", "Novela de caballerías"));
        libros.add(new Libro(6, "La Odisea", "Homero", "Editorial Desconocida", "Siglo VIII a.C.", "Épica"));
        libros.add(new Libro(7, "Orgullo y prejuicio", "Jane Austen", "Editorial Thomas Egerton", "1813", "Romance"));
        libros.add(new Libro(8, "Moby-Dick", "Herman Melville", "Editorial Richard Bentley", "1851", "Aventura"));
        libros.add(new Libro(9, "El Gran Gatsby", "F. Scott Fitzgerald", "Editorial Charles Scribner's Sons", "1925",
                "Drama"));
        libros.add(new Libro(10, "En busca del tiempo perdido", "Marcel Proust", "Editorial Grasset", "1913",
                "Novela modernista"));
        libros.add(new Libro(11, "Harry Potter y la piedra filosofal", "J.K. Rowling", "Editorial Bloomsbury", "1997",
                "Fantasía"));
        libros.add(new Libro(12, "Los juegos del hambre", "Suzanne Collins", "Editorial Scholastic", "2008",
                "Ciencia ficción"));
        libros.add(new Libro(13, "El código Da Vinci", "Dan Brown", "Editorial Doubleday", "2003", "Misterio"));
        libros.add(new Libro(14, "El alquimista", "Paulo Coelho", "Editorial Rocco", "1988", "Novela espiritual"));
        libros.add(
                new Libro(15, "El nombre del viento", "Patrick Rothfuss", "Editorial DAW Books", "2007", "Fantasía"));
        libros.add(new Libro(16, "La sombra del viento", "Carlos Ruiz Zafón", "Editorial Planeta", "2001", "Misterio"));
        libros.add(new Libro(17, "El retrato de Dorian Gray", "Oscar Wilde", "Editorial Lippincott's Monthly Magazine",
                "1890", "Clásico gótico"));
        libros.add(new Libro(18, "Los miserables", "Victor Hugo", "Editorial Charles Laffite", "1862", "Drama"));

    }

    public ArrayList<Libro> getLibros() {
        return this.libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;

    }

    public void inserta(Libro libro) {
        libros.add(libro);

    }

    public void borrar(int id) {
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            Libro li = it.next();
            if (li.getId() == id) {
                it.remove();
                break;
            }
        }
    }

    public void modificar(Libro libro) {
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            Libro li = it.next();
            if (li.getId() == libro.getId()) {
                li.setTitulo(libro.getTitulo());
                li.setAutor(libro.getAutor());
                li.setEditorial(libro.getEditorial());
                li.setFecha(libro.getFecha());
                li.setTematica(libro.getTematica());
                break;
            }
        }

    }

    public Libro getLibro(int id) {
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            Libro li = it.next();
            if (li.getId() == id) {
                return li;
            }
        }
        return null;
    }
}
