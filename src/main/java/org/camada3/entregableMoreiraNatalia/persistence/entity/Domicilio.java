package org.camada3.entregableMoreiraNatalia.persistence.entity;

import javax.persistence.*;

@Entity
@Table( name = "domicilio")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String calle;
    @Column
    private  int numero;
    @Column
    private String dpto;
    @Column
    private String ciudad;
    @Column
    private String cp;

    public Domicilio(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){ this.id = id;}

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


}
