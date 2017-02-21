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
    private ArrayList<TagsNeg> Tags=new ArrayList();
    private ArrayList<String> titulos=new ArrayList();
    

    public TablaEscaneados(ArrayList<TagsNeg> tags){
        Tags=tags;
        titulos.add("ID");
        titulos.add("estado");
    }
    
    public void IniciarTabla(ArrayList<TagsNeg> tags){
        Tags=tags;
    }
            
    
    @Override
    public int getRowCount() {
        return Tags.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TagsNeg tag=null;
        tag=Tags.get(rowIndex);
        String estad;
        if(tag.getEstado()== 1){
                estad="no Registrado";
            }else{
                estad="Registrado";
            }
               switch(columnIndex){
            case 0: return tag.getTag().getTagID();
            case 1: return estad;
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        return titulos.get(column);
    }

    
}
