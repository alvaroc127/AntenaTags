/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author PERSONAL
 */
public class ConectionBD {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author felipe
 */

    private static String JDBC_DRIVER="org.postgresql.Driver";
    private static String db="BicicletasDB";
    private static String JDBC_URL="jdbc:postgresql://localhost:5432/"+db;
    private static String JDBC_USER="postgres";
    private static String JDBC_PASWORD="admin";//0000 en u sdefetnecto
    private static Driver driver=null;
    private static ConectionBD co;
            
    
    
    public static ConectionBD getConexion(){
    if(co==null){
    co=new ConectionBD();
    return co;
    }else
        {
            return co;
        }
    }
    
    
    public static synchronized Connection getConecxion() throws SQLException{
        if(driver==null){
            try{
            Class jdbcDriverClas=Class.forName(JDBC_DRIVER);
                driver=(Driver)jdbcDriverClas.newInstance();
            }catch(Exception ex){
                System.out.println("ocurrio un error");
                ex.printStackTrace();
            }
        
        }
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASWORD);
    }
    
    
    public static void close(ResultSet rs){
        try{
        if(rs != null){
        rs.close();
        }
        }catch(SQLException ex){
        ex.printStackTrace();
        }
    }
    
    public static void close(Connection co){
        try{
            if(co!=null){
            co.close();
            }
        }catch(SQLException ex){
        ex.printStackTrace();
        }
    }
    
    public static void close(PreparedStatement pst){
    try{
        if(pst != null){
            pst.close();
        }
    }catch(SQLException ex){
    ex.printStackTrace();
    }
    
    }
    
}
