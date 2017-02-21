/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Negocio.TablaEscaneados;
import Negocio.TagsNeg;
import Servicios.TagsBD;
import java.util.ArrayList;



/**
 *
 * @author PERSONAL
 */
public class ControladorTags {
    
    private Negocio.ReaderAlien readAlien;
    private TagsBD tagbd;
    private ArrayList<Negocio.TagsNeg> Tags;
    private Negocio.TagsNeg tag;
    private Negocio.TablaEscaneados tab;
    
    
    public void ControladorTags(){
        readAlien=new Negocio.ReaderAlien();
        tagbd=new TagsBD();
        tag=new TagsNeg();
    }
    
    public String buscarTag(){
        String out=null;
        try{
            if(readAlien == null){
            readAlien = new Negocio.ReaderAlien();
            }
        out=readAlien.ListenerTags();
        }catch(NullPointerException EX){
        EX.printStackTrace();
        }catch(Exception ex){
        ex.printStackTrace();
        }
        return out;
    }
    
    
    public void cargarTabs(){
    if(tab==null){
    tab=new TablaEscaneados(Tags);
    }else{
        tab.IniciarTabla(Tags);
        }
    }
    
    
    public void loadTags(String id, int estado){
    if(tag==null)
        tag=new TagsNeg();
    tag.setTag(tag.loadTag(id));
    tag.setEstado(estado);
    }
    
    public void insertarTag(){
        if(tagbd==null)
            tagbd= new TagsBD();
        tagbd.InsertaTag(tag);
    }
    
    public TablaEscaneados getTabla(){
    return tab;
    }
    
   
    
  
    
}
