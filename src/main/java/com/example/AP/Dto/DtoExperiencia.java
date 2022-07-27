
package com.example.AP.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {
    @NotBlank
    private String empresaExp;
    @NotBlank
    private String descripcionExp;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String empresaExp, String descripcionExp) {
        this.empresaExp = empresaExp;
        this.descripcionExp = descripcionExp;
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

    