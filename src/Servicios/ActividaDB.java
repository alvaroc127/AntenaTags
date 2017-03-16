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
    
    private static String consultaActividad="Select * from \"Actividad\" where fecha BETWEEN ?  AND current_date AND hora >  ? AND hora < ?"; 
    private static String insertarActivdad="INSERT INTO \"Actividad\" (fecha,\"Id\",\"Numero_Chasis\",cedula,hora) values (?,?,?,?,?);";

    public ActividaDB() {
    }
    
    
    
    
    public ArrayList<Negocio.Actividad> consultaActividad(java.sql.Date fecha,java.sql.Time horaIni, java.sql.Time horaFin){
    ArrayList<Negocio.Actividad> actividades=new ArrayList<Negocio.Actividad>();
    Connection con=null;
    PreparedStatement stat=null;
    ResultSet  resul=null;
    Negocio.TagsNeg tagPr=null;
    try{
    con= ConectionBD.getConecxion();
    stat=con.prepareStatement(consultaActividad);
    int index=1;
    stat.setDate(index++,fecha);
    stat.setTime(index++,horaIni);
    stat.setTime(index++,horaFin);
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
    
       public void insertarActividad(Actividad activi){
        Connection con=null;
        PreparedStatement stat=null;
        int rows=0;
        try{
        con=ConectionBD.getConecxion();
        stat=con.prepareStatement(insertarActivdad);
        int index=1;
        stat.setDate(index++,activi.getFecha());
        stat.setString(index++,activi.getId());
        stat.setInt(index++, activi.getNumero_Chasis());
        stat.setLong(index++,activi.getCedula());
        stat.setTime(index++,activi.getHora());
        rows=stat.executeUpdate();
       }catch(SQLException exp){
       exp.printStackTrace();
       }finally{
        ConectionBD.close(con);
        ConectionBD.close(stat);
        }
    }
    
    
}
