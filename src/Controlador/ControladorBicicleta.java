/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.Bicicleta;
import Servicios.BicicletaBD;

/**
 *
 * @author PERSONAL
 */
public class ControladorBicicleta {
    
    
    private Bicicleta bici;
    private BicicletaBD bicibd;

    public ControladorBicicleta() {
        bici=new Bicicleta();
        bicibd=new BicicletaBD();
    }
    
    public  void loadBicicleta(int chasis,String color, String marca){
        bici.setCodChasis(chasis);
        bici.setColor(color);
        bici.setMarca(marca);
    }
    
    public void guardarBici(String ID, int cedula){
    bicibd.insertarBici(bici,ID,cedula);
    }
    
    
    public void setChasis(int chasis){
        bici.setCodChasis(chasis);
    }
    
    
    public void setColor(String color){
    bici.setColor(color);
    }
    
    
    public void setMarca(String marca){
    bici.setMarca(marca);
    }
    
    
    public Bicicleta buscarBici(int Numero_Ch){
    return bicibd.consultarBicicleta(Numero_Ch);
    }
    
}
