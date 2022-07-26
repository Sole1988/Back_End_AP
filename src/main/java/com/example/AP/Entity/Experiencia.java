
package com.example.AP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    private int id;

    private String empresaExp;

    private String descripcionExp;

    public Experiencia() {
    }

    public Experiencia(String empresaExp, String descripcionExp) {
        this.empresaExp = empresaExp;
        this.descripcionExp = descripcionExp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresaExp() {
        return empresaExp;
    }

    public void setEmpresaExp(String empresaExp) {
        this.empresaExp = empresaExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

}