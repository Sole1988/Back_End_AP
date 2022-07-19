
package com.example.AP.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   
    private Long idSkills;

    private String nombreSkills;

    private Long porcentajeSkills;

    private String imagenSkills;

    public Skills() {
    }

    public Skills(Long idSkills, String nombreSkills, Long porcentajeSkills, String imagenSkills) {
        this.idSkills = idSkills;
        this.nombreSkills = nombreSkills;
        this.porcentajeSkills = porcentajeSkills;
        this.imagenSkills = imagenSkills;
    }

    public Long getIdSkills() {
        return idSkills;
    }

    public void setIdSkils(Long idSkills) {
        this.idSkills = idSkills;
    }

    public String getNombreSkills() {
        return nombreSkills;
    }

    public void setNombreSkills(String nombreSkills) {
        this.nombreSkills = nombreSkills;
    }

    public Long getPorcentajeSkills() {
        return porcentajeSkills;
    }

    public void setPorcentajeSkills(Long porcentajeSkills) {
        this.porcentajeSkills = porcentajeSkills;
    }

    public String getImagenSkills() {
        return imagenSkills;
    }

    public void setImagenSkills(String imagenSkills) {
        this.imagenSkills = imagenSkills;
    }

}
