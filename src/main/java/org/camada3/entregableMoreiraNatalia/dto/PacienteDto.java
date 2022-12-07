package org.camada3.entregableMoreiraNatalia.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PacienteDto implements Dto {

    private Integer id;
    private String nombre;
    private String apellido;
    private DomicilioDto domicilio;
    private int telefono;
    private int dni;
    private LocalDate fechaAlta;

    public PacienteDto() {}

    @Override
    public String toString(){
        return "Paciente: " + nombre + " " + apellido +
                " DNI: " + dni +
                " Domicilio: " + domicilio.toString() +
                " Tel: " + telefono;
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

    public DomicilioDto getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DomicilioDto domicilio) {
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Integer getId() {
        return id;
    }
}
