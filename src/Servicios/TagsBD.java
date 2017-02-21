/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PERSONAL
 */
public class TagsBD {
    
    private String Inserta_Tag= "INSERT INTO public.\"Tags\" (\"Id\", estado) VALUES (?, ?);";
    private String Consulta_Tag="Select * from \"Tags\" Where Id = ?;";
    
    private Negocio.TagsNeg tag;

    public TagsBD() {
    }

    public TagsBD(Negocio.TagsNeg tag) {
        this.tag = tag;
    }
    
    
    public int InsertaTag(Negocio.TagsNeg tag){
        Connection con=null;
        PreparedStatement stat=null;
        int rows=0;
        try{
        con=ConectionBD.getConecxion();
        stat=con.prepareStatement(Inserta_Tag);
        int index=1;
        stat.setString(index++,tag.getTag().getTagID());
        stat.setInt(index++,  tag.getEstado());
        rows=stat.executeUpdate();
       }catch(SQLException exp){
       exp.printStackTrace();
       }finally{
        ConectionBD.close(con);
        ConectionBD.close(stat);
        }
        return rows;
    }
    
    public Negocio.TagsNeg consultarTag(String id){
    Connection con=null;
    PreparedStatement stat=null;
    ResultSet  resul=null;
    Negocio.TagsNeg tagPr=null;
    try{
    con= ConectionBD.getConecxion();
    stat=con.prepareStatement(Consulta_Tag);
    int index=1;
    stat.setString(index++, id);
    resul=stat.executeQuery();
    while(resul.next()){
       Negocio.TagsNeg tag=new Negocio.TagsNeg();
       tag.loadTag(resul.getString("Id"));
       tag.setEstado(resul.getInt("estado"));
       tagPr=tag;
        }
    }catch(SQLException exp){
    exp.printStackTrace();
    }finally{
    ConectionBD.close(con);
    ConectionBD.close(stat);
    ConectionBD.close(resul);
    return tagPr;
        }
    }
    
}
