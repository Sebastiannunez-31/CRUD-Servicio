/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author _Sebastián_
 */
public interface CRUD {
    
    public List listar();
    public User listarID(int id);
    public String add(String nombre,String apellido,String carrera );
    public String edit(int id,String nombre,String apellido,String carrera );
    public User delete(int id);
     
}
