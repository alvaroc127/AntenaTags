/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import java.sql.Date;

/**
 *
 * @author User
 */
public class Actividad {
    
    String fecha;
    int Numero_Chasis;
    String Id;
    int cedula;

    public Actividad() {
    }

    public Actividad(String fecha, int Numero_Chasis, String Id, int cedula) {
        this.fecha = fecha;
        this.Numero_Chasis = Numero_Chasis;
        this.Id = Id;
        this.cedula = cedula;
    }



    
    
    
    
    
    
    
    
    public void setFecha(Date fecha){
       //cambiar el date sql a date java util l date 
        //convertir el sql date en JAVA DATE y convertir a string
    }
    
    
}
