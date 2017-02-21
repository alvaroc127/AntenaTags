/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import com.alien.enterpriseRFID.tags.Tag;

/**
 *
 * @author PERSONAL
 */
public class TagsNeg {
    
    private Tag tag;
    private int estado;

    public TagsNeg() {
        tag=null;
    }

    public TagsNeg(Tag tag, int estado) {
        this.tag = tag;
        this.estado = estado;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public int getEstado(){
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public Tag loadTag(String id){
        Tag tag = new Tag(id);
        return tag;
    }
    
    
    
    
}
