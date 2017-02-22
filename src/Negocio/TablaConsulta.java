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
 * @author User
 */
public class TablaConsulta extends AbstractTableModel {
    private ArrayList<Actividad>actividades =new ArrayList<Actividad>();
    private ArrayList<String> titulos = new ArrayList<String>();

    public TablaConsulta(ArrayList<Actividad> activi) {
        actividades=activi;
        titulos.add("fecha");
        titulos.add("ID");
        titulos.add("Numero_Chasis");
        titulos.add("cedula");
    }

    public void iniciarTabla(ArrayList<Actividad> activi){
    this.actividades=activi;
    titulos.add("fecha");
    titulos.add("ID");     
    titulos.add("Numero_Chasis");
    titulos.add("cedula");
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
        Actividad act=null;
        act=actividades.get(rowIndex);
           switch(columnIndex){
            case 0: return act.getFecha().toString();
            case 1: return act.getId();
            case 2: return act.getNumero_Chasis();
            case 3: return act.getCedula();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        return titulos.get(column);
    }
    
    
}
