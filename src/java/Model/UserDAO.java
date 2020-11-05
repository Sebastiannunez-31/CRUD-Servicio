/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author _Sebastián_
 */
public class UserDAO implements CRUD {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;

    Conection conex = new Conection();

    int res;
    String msj;
    User user = new User();

    @Override
    public List listar() {

        List<User> datos = new ArrayList<>();
        String sql = "select * from user";
        try {

            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setCarrera(rs.getString("carrera"));
                datos.add(u);
            }

        } catch (Exception e) {
        }
        return datos;
    }

    @Override
    public User listarID(int id) {
        String sql = "select * from user where id=" + id;

        

        try {

            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setCarrera(rs.getString("carrera"));
            }
        } catch (Exception e) {
        }
        return user;
    }

    @Override
    public String add(String nombre, String apellido, String carrera) {

        String sql = "insert into user(nombre,apellido,carrera)values(?,?,?)";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, carrera);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Alumno Agregado";

            } else {

                msj = "Error";

            }

        } catch (Exception e) {
        }
        return msj;

    }

    @Override
    public String edit(int id, String nombre, String apellido, String carrera) {
        String sql = "update user set nombre=?,apellido=?,carrera=? where id=" + id;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, carrera);
            res = ps.executeUpdate();

            if (res == 1) {
                msj = "Alumno Actualizado";
            } else {
                msj = "Error";

            }
        } catch (Exception e) {
        }
        return msj;

    }

    @Override
    public User delete(int id) {
        String sql = "delete from user where id=" + id;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }return user;
    }

}
