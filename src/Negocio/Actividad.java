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
    
    Date fecha;
    int Numero_Chasis;
    String Id;
    long cedula;

    public Actividad() {
    }

    public Actividad(Date fecha, int Numero_Chasis, String Id, long cedula) {
        this.fecha = fecha;
        this.Numero_Chasis = Numero_Chasis;
        this.Id = Id;
        this.cedula = cedula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumero_Chasis() {
        return Numero_Chasis;
    }

    public void setNumero_Chasis(int Numero_Chasis) {
        this.Numero_Chasis = Numero_Chasis;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

   

 
}

    

