/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.Actividad;
import Negocio.TablaEscaneados;
import Servicios.ActividaDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 *
 * @author felipe
 */
public class ControladorActividades {
    
    private Negocio.Actividad activi;
    private Servicios.ActividaDB actividadBD;
    java.sql.Date fech;
    java.util.Date ulfec;
    private ArrayList<Actividad> actividades;
    private Controlador.ControladorBicicleta conBici;
    private TablaEscaneados tabEscan;
    
    

    public ControladorActividades() {
        activi =  new Actividad();
        actividadBD= new ActividaDB();
        ulfec=new java.util.Date();
        actividades=new ArrayList<>();
        conBici=new ControladorBicicleta();
    }
    
    
    public ArrayList<Negocio.Actividad> consultarActividades(java.sql.Date fecha,java.sql.Time HoraIni,java.sql.Time horaFin){
        actividades = actividadBD.consultaActividad(fecha,HoraIni,horaFin);
        return actividadBD.consultaActividad(fecha,HoraIni,horaFin);
    }
    
    public void convertDate(String fech) {
        SimpleDateFormat dat= new SimpleDateFormat("dd/mm/yyyy");
        try{
        ulfec = dat.parse(fech);
        }catch(ParseException pa){
        pa.printStackTrace();
        }
    }
    
   public java.sql.Date fechSQL(){
   java.sql.Date fech=new java.sql.Date(ulfec.getTime());
   return fech;
   }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }
    
    public void creatActivity(int numChasis,String ID, int cedula){
        Actividad acti=new Actividad(numChasis, ID, cedula);
        actividades.add(acti);
    }
    
    public void clearActividads(){
    actividades.clear();
    }
    
    public void initTab(){
    if(tabEscan== null){
        tabEscan=new TablaEscaneados(actividades);
    }else{
        tabEscan.IniciarTabla(actividades);
        }
    }
    
    public TablaEscaneados getTab(){
    return tabEscan;
    }
    
    
    public void insertarActividades(){
    for(int i=0; i<actividades.size();i++){
        if(actividades.get(i).getCedula()>0)
    actividadBD.insertarActividad(actividades.get(i));
        }
    }
    
}
