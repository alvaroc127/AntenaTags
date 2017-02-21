/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Negocio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author PERSONAL
 */
public class UsuarioBD {

    private String INSERTAR_Usuario="INSERT INTO public.\"Ciclista\" (\"Nombre\", cedula, correo) VALUES (?,?, ?);";
    private String Consulta_Usuario="";
    
    
    public UsuarioBD() {
        
    }
    
    
    public void insertarUusario(Usuario usu){
        Connection con=null;
        PreparedStatement stat=null;
        int rows=0;
        try{
        con= ConectionBD.getConecxion();
        stat= con.prepareStatement(INSERTAR_Usuario);
        int index=1;
        stat.setString(index++,usu.getNombre());
        stat.setLong(index++, usu.getCedula());
        stat.setString(index++, usu.getCorreo());
        rows= stat.executeUpdate();
        }catch(SQLException SQLE){
        SQLE.printStackTrace();
        }finally{
        ConectionBD.close(con);
        ConectionBD.close(stat);
        }
    
    }
    
    
}
