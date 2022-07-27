
package com.example.AP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreSkill;
    private String porcentajeSkill;
    private String imagenSkill;

    public Skill() {
    }

    public Skill(String nombreSkill, String porcentajeSkill, String imagenSkill) {
        this.nombreSkill = nombreSkill;
        this.porcentajeSkill = porcentajeSkill;
        this.imagenSkill = imagenSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public String getPorcentajeSkill() {
        return porcentajeSkill;
    }

    public void setPorcentajeSkill(String porcentajeSkill) {
        this.porcentajeSkill = porcentajeSkill;
    }

    public String getImagenSkill() {
        return imagenSkill;
    }

    public void setImagenSkill(String imagenSkill) {
        this.imagenSkill = imagenSkill;
    }
    
    
    
}
