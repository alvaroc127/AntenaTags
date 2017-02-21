/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Negocio.Usuario;
import Servicios.UsuarioBD;
/**
 *
 * @author PERSONAL
 */
public class ControladorGUIUsuario {
    
    
    private Usuario usuario;
    private UsuarioBD usuarioBd;
   
    

    public ControladorGUIUsuario() {
        usuario=new Usuario();
        usuarioBd=new UsuarioBD();
    }
    

    public void setNombre(String nombre){
    usuario.setNombre(nombre);
    }
    
    
    public void setCedula(long  cedula){
    usuario.setCedula(cedula);
    }
   
    public void setCorreo(String correo){
       usuario.setCorreo(correo);
    }
    
    public void insertarUusario(){
        System.out.println(usuario.getNombre());
        usuarioBd.insertarUusario(usuario);
    }
    
    
}
