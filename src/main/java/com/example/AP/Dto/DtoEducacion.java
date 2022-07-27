
package com.example.AP.Dto;

import javax.validation.constraints.NotBlank;


public class DtoEducacion {

    @NotBlank
    private String tituloEdu;
    @NotBlank
    private String fechaEdu;
    @NotBlank
    private String descripcionEdu;
    @NotBlank
    private String InstitutoEdu;
    @NotBlank
    private String imagenEdu;

    public DtoEducacion() {
    }

    public DtoEducacion(String tituloEdu, String fechaEdu, String descripcionEdu, String InstitutoEdu, String imagenEdu) {
        this.tituloEdu = tituloEdu;
        this.fechaEdu = fechaEdu;
        this.descripcionEdu = descripcionEdu;
        this.InstitutoEdu = InstitutoEdu;
        this.imagenEdu = imagenEdu;
    }

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getFechaEdu() {
        return fechaEdu;
    }

    public void setFechaEdu(String fechaEdu) {
        this.fechaEdu = fechaEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public String getInstitutoEdu() {
        return InstitutoEdu;
    }

    public void setInstitutoEdu(String InstitutoEdu) {
        this.InstitutoEdu = InstitutoEdu;
    }

    public String getImagenEdu() {
        return imagenEdu;
    }

    public void setImagenEdu(String imagenEdu) {
        this.imagenEdu = imagenEdu;
    }
    
        
    
}
