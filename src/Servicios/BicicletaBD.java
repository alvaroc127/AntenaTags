/*



 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Negocio.Bicicleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PERSONAL
 */
public class BicicletaBD {
    
    private String InsertaBicicleta="INSERT INTO public.\"Cicla\" (\"Marca\", \"Numero_Chasis\", \"Color\", \"Id\", cedula) VALUES (?, ?, ?, ?, ?);";	
    private String consultaBicileta="SELECT *  FROM public.\"Cicla\";";

    public BicicletaBD() {
    }
    
    
    public void insertarBici(Bicicleta Bici, String ID, int cedula){
        Connection con=null;
        PreparedStatement stat=null;
        int rows=0;
        try{
        con=ConectionBD.getConecxion();
        stat=con.prepareStatement(InsertaBicicleta);
        int index=1;
        stat.setString(index++, Bici.getMarca());
        stat.setInt(index++, Bici.getCodChasis());
        stat.setString(index++,Bici.getColor());
        stat.setString(index++, ID);
        stat.setInt(index++, cedula);
        rows=stat.executeUpdate();
       }catch(SQLException exp){
       exp.printStackTrace();
       }finally{
        ConectionBD.close(con);
        ConectionBD.close(stat);
        }
    }
    
    
    public Bicicleta consultarBicicleta(int num_chasis){
    Bicicleta bici = new Bicicleta();
    Connection con=null;
    PreparedStatement stat=null;
    ResultSet  resul=null;
    Negocio.TagsNeg tagPr=null;
    try{
    con= ConectionBD.getConecxion();
    stat=con.prepareStatement(consultaBicileta);
    int index=1;
    stat.setInt(index++,num_chasis);
    resul=stat.executeQuery();
    while(resul.next()){
       bici.setCodChasis(resul.getInt("Numero_Chasis"));
       bici.setColor(resul.getString("color"));
       bici.setMarca(resul.getString("marca"));
        }
    }catch(SQLException exp){
    exp.printStackTrace();
    }finally{
    ConectionBD.close(con);
    ConectionBD.close(stat);
    ConectionBD.close(resul);
    return bici;
        }
    }
    
    
    
}
                                                                                                                   