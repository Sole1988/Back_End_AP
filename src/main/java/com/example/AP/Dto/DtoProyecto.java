
package com.example.AP.Dto;

import javax.validation.constraints.NotBlank;


public class DtoProyecto {
        
    @NotBlank
    private String tituloProyecto;
    @NotBlank
    private String fechaProyecto;
    @NotBlank
    private String descripcionProyecto;

    public DtoProyecto() {
    }

    public DtoProyecto(String tituloProyecto, String fechaProyecto, String descripcionProyecto) {
        this.tituloProyecto = tituloProyecto;
        this.fechaProyecto = fechaProyecto;
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getTituloProyecto() {
        return tituloProyecto;
    }

    public void setTituloProyecto(String tituloProyecto) {
        this.tituloProyecto = tituloProyecto;
    }

    public String getFechaProyecto() {
        return fechaProyecto;
    }

    public void setFechaProyecto(String fechaProyecto) {
        this.fechaProyecto = fechaProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    

}
