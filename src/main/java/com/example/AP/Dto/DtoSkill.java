
package com.example.AP.Dto;

import javax.validation.constraints.NotBlank;


public class DtoSkill {
    
    @NotBlank
    private String nombreSkill;
    @NotBlank
    private String porcentajeSkill;
    @NotBlank
    private String imagenSkill;

    public DtoSkill() {
    }

    public DtoSkill(String nombreSkill, String porcentajeSkill, String imagenSkill) {
        this.nombreSkill = nombreSkill;
        this.porcentajeSkill = porcentajeSkill;
        this.imagenSkill = imagenSkill;
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
