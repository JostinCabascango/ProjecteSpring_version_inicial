package com.example.demo.service;

import com.example.demo.bean.Libro;
import com.example.demo.repository.BaseDatos3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BaseDatos3Service implements IBaseDatos3 {
    public BaseDatos3Service() {
        super();
    }

    @Autowired(required = true)
    BaseDatos3 bd;

    @Override
    public void insertar(Libro libro) {
        bd.save(libro);

    }

    @Override
    public void borrar(int id) {
        bd.deleteById(id);

    }

    @Override
    public void modificar(Libro libro) {
        bd.save(libro);
    }

    @Override
    public Libro getLibro(int id) {
        Optional<Libro> l = bd.findById(id);
        return l.get();
    }

    @Override
    public ArrayList<Libro> getLibros() {
        return (ArrayList<Libro>) bd.findAll();
    }

    @Override
    public boolean compruebaUsuario(String usuario, String password) {
        boolean check = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conex = "jdbc:mysql://localhost:3306/biblioteca_online";
            Connection conexion = DriverManager.getConnection(conex, "root", "");
            Statement s = conexion.createStatement();
            String sql = "select * from usuarios where nombre='" + usuario + "' and password='" + password + "'";
            s.execute(sql);
            ResultSet rs = s.getResultSet();
            rs.next();
            if (rs.getInt(1) > 0) {
                check = true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return check;
    }
}
