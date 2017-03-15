/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

/**
 *
 * @author User
 */
public class Actividad {
    
    Date fecha;
    Time hora;
    int Numero_Chasis;
    String Id;
    long cedula;

    public Actividad() {
    }

    public Actividad(Date fecha,Time hora,int Numero_Chasis, String Id, long cedula) {
        this.fecha = fecha;
        this.hora=hora;
        this.Numero_Chasis = Numero_Chasis;
        this.Id = Id;
        this.cedula = cedula;
    }

    
     public Actividad(int Numero_Chasis, String Id, long cedula) {
        this.Numero_Chasis = Numero_Chasis;
        this.Id = Id;
        this.cedula = cedula;
        loadDate();
        loadTime();
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

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    
    public void currentDate(){
        loadDate();
        loadTime();
    }
    
    public void loadDate(){
        java.util.Date dat=new java.util.Date();
        if(fecha==null){
            fecha=new Date(dat.getTime());
        }else{
        fecha.setTime(dat.getTime());
        }
    }
    
    
    public void loadTime(){
    LocalTime locTime= LocalTime.now();
    if(hora== null){
        hora=new Time(locTime.getHour(), locTime.getMinute(), locTime.getSecond());
        }else{
            hora.setHours(locTime.getHour());
            hora.setMinutes(locTime.getMinute());
            hora.setSeconds(locTime.getSecond());
        }
    }
   

 
}

    

