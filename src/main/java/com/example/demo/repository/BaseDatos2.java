package com.example.demo.repository;

import com.example.demo.bean.Libro;

import java.sql.*;
import java.util.ArrayList;

public class BaseDatos2 {
    private Connection conexion;

    public BaseDatos2() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conex = "jdbc:mysql://localhost:3306/biblioteca_online";
            this.conexion = DriverManager.getConnection(conex, "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertar(Libro libro) {
        String query = "insert into libros(id, titulo, autor, editorial, fecha, tematica) values(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement;
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, libro.getId());
            preparedStatement.setString(2, libro.getTitulo());
            preparedStatement.setString(3, libro.getAutor());
            preparedStatement.setString(4, libro.getEditorial());
            preparedStatement.setString(5, libro.getFecha());
            preparedStatement.setString(6, libro.getTematica());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void borrar(int id) {
        String query = "delete from libros where id=" + id;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modificar(Libro libro) {
        String query = "update libros set titulo=?, autor=?, editorial=?, fecha=?, tematica=? where id=?";
        try {
            PreparedStatement preparedStatement;
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, libro.getTitulo());
            preparedStatement.setString(2, libro.getAutor());
            preparedStatement.setString(3, libro.getEditorial());
            preparedStatement.setString(4, libro.getFecha());
            preparedStatement.setString(5, libro.getTematica());
            preparedStatement.setInt(6, libro.getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Libro getLibro(int id) {
        Libro libro = null;
        try {
            Statement s = conexion.createStatement();
            String sql = "select * from libros where id=" + id;
            s.execute(sql);
            ResultSet rs = s.getResultSet();
            rs.next();
            libro = new Libro(rs.getInt(1), rs.getString("titulo"), rs.getString("autor"), rs.getString("editorial"), rs.getString("fecha"), rs.getString("tematica"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return libro;

    }

    public ArrayList<Libro> getLibros() {
        ArrayList<Libro> lista = new ArrayList<>();
        try {
            Statement s = conexion.createStatement();
            String sql = "select * from libros";
            s.execute(sql);
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                Libro libro = new Libro(rs.getInt(1), rs.getString("titulo"), rs.getString("autor"), rs.getString("editorial"), rs.getString("fecha"), rs.getString("tematica"));
                lista.add(libro);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public boolean compruebaUsuario(String usuario, String password) {
        boolean check = false;
        try {
            Statement s = conexion.createStatement();
            String sql = "select * from usuarios where usuario='" + usuario + "' and password='" + password + "'";
            s.execute(sql);
            ResultSet rs = s.getResultSet();
            rs.next();
            if (rs.getInt(1) > 0) {
                check = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

}
