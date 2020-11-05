/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.UserDAO;
import Model.User;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author _Sebastián_
 */
@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

   UserDAO dao= new UserDAO();
    
    @WebMethod(operationName = "listar")
    public List<User> listar() {
        
        List datos=dao.listar();
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregar")
    public String agregar(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "carrera") String carrera) {
       
        String datos=dao.add(nombre, apellido, carrera);
        
        
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListarID")
    public User ListarID(@WebParam(name = "id") int id) {
       User user=dao.listarID(id);
        return user;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Actualizar")
    public String Actualizar(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "carrera") String carrera) {
        String datos=dao.edit(id, nombre, apellido, carrera);
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Eliminar")
    public User Eliminar(@WebParam(name = "id") int id) {

        User u=dao.delete(id);
        return u;
    }
}
