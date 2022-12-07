package org.camada3.entregableMoreiraNatalia.dto;

import java.io.Serializable;

public class DomicilioDto implements Dto {

    private Integer id;
    private String calle;
    private  int numero;
    private String dpto;
    private String ciudad;
    private String cp;

    public DomicilioDto() {}

    public DomicilioDto(String calle, int numero, String dpto, String ciudad, String cp) {
        this.calle = calle;
        this.numero = numero;
        this.dpto = dpto;
        this.ciudad = ciudad;
        this.cp = cp;
    }

    @Override
    public String toString(){
        return calle + " " + numero + " " + dpto + ", " + ciudad + " CP: " + cp;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Integer getId() {
        return id;
    }
}
