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
    
    
    
    public void ControladorTags(){
        readAlien=new Negocio.ReaderAlien();
        tagbd=new TagsBD();
        tag=new TagsNeg();
    }
    
    public void buscarTag(){
        try{
            if(readAlien == null){
            readAlien = new Negocio.ReaderAlien();
            }
        readAlien.clearTags();
        readAlien.ListenerTags();
        Tags=readAlien.getListTags();
        }catch(NullPointerException EX){
        EX.printStackTrace();
        }catch(Exception ex){
        ex.printStackTrace();
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
    
   
    
    
    public void insertarTags(){
        for(int i=0;i<Tags.size();i++){
            insertarTag();
        }
    }
   
    
    public ArrayList<TagsNeg> getTags(){
    return Tags;
    }
    
  
    public void setBooleanStop(boolean stop){
    readAlien.setStop(stop);
    }
    
}
