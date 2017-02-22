package Servicios;


import Negocio.Actividad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author felipe
 */
public class ActividaDB {
    
    private static String consultaActividad="Select * from \"Actividad\" where fecha  BETWEEN CAST (? AS DATE) AND current_date"; 
    private static String insertarActivdad="INSERT INTO \"Actividad\" (fecha,Id,cedula,) values (?,?,?,?);";

    public ActividaDB() {
    }
    
    
    
    
    public ArrayList<Negocio.Actividad> consultaActividad(java.sql.Timestamp fecha){
    ArrayList<Negocio.Actividad> actividades=new ArrayList<Negocio.Actividad>();
    Connection con=null;
    PreparedStatement stat=null;
    ResultSet  resul=null;
    Negocio.TagsNeg tagPr=null;
    try{
    con= ConectionBD.getConecxion();
    stat=con.prepareStatement(consultaActividad);
    int index=1;
    stat.setTimestamp(index++,fecha);
    //stat.setTimestamp(index++,fecha);
    resul=stat.executeQuery();
    while(resul.next()){
       Actividad act=new Actividad();
       act.setFecha(resul.getDate("fecha"));
       act.setNumero_Chasis(resul.getInt("Numero_Chasis"));
       act.setId(resul.getString("Id"));
       act.setCedula(resul.getLong("cedula"));
       actividades.add(act);
    }
    }catch(SQLException exp){
    exp.printStackTrace();
    }finally{
    ConectionBD.close(con);
    ConectionBD.close(stat);
    ConectionBD.close(resul);
    return actividades;
        }
    }
    
    
    
    
}
