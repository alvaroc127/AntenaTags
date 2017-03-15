/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PERSONAL
 */
public class TablaEscaneados extends AbstractTableModel {
    private ArrayList<Actividad> actividades=new ArrayList();
    private ArrayList<String> titulos=new ArrayList();
    

    public TablaEscaneados(ArrayList<Actividad> acti){
        actividades=acti;
        titulos.add("ID");
        titulos.add("numero Chasis");
        titulos.add("Hora");
        titulos.add("Fecha");
        titulos.add("Cedula");
    }
    
    public void IniciarTabla(ArrayList<Actividad> actividades){
        this.actividades=actividades;
    }
            
    
    @Override
    public int getRowCount() {
        return actividades.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Actividad acti=null;
        acti=actividades.get(rowIndex);
       switch(columnIndex){
            case 0: return acti.getId();
            case 1: return acti.getNumero_Chasis();
            case 2: return acti.getHora().toString();
            case 3: return acti.getFecha().toString();
            case 4: return acti.getCedula();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        return titulos.get(column);
    }

    
}
