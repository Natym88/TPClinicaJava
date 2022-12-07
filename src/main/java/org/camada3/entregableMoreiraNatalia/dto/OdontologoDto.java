package org.camada3.entregableMoreiraNatalia.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class OdontologoDto implements Dto {

    private String nombre;
    private String apellido;
    private Integer id;
    private int matricula;
    private ArrayList<TurnoDto> turnos = new ArrayList<>();

    public OdontologoDto (){}

    public OdontologoDto ( String nombre, String apellido, int matricula){
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    @Override
    public String toString(){
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula=" + matricula +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Collection<TurnoDto> getTurnos() {
        return turnos;
    }

}
