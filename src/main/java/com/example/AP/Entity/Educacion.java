
package com.example.AP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String tituloEdu;

    private String fechaEdu;

    private String descripcionEdu;

    private String InstitutoEdu;

    private String imagenEdu;

    public Educacion() {
    }

    public Educacion(String tituloEdu, String fechaEdu, String descripcionEdu, String InstitutoEdu, String imagenEdu) {
        this.tituloEdu = tituloEdu;
        this.fechaEdu = fechaEdu;
        this.descripcionEdu = descripcionEdu;
        this.InstitutoEdu = InstitutoEdu;
        this.imagenEdu = imagenEdu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


