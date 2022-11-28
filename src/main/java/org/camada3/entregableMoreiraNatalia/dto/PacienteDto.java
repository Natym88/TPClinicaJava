package org.camada3.entregableMoreiraNatalia.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PacienteDto implements Serializable {

    private Integer id;
    private String nombre;
    private String apellido;
    private DomicilioDto domicilio;
    private int telefono;
    private int dni;
    private LocalDate fechaAlta;

    public PacienteDto() {}

    public PacienteDto(String nombre, String apellido, DomicilioDto domicilio, int telefono, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.dni = dni;
    }

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

    public void setId(int id) {
        this.id = id;
    }
}
