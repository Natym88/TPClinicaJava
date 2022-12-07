package org.camada3.entregableMoreiraNatalia.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turno")
public class Turno {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private LocalDate fecha;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn( name="paciente_id")
    private Paciente paciente;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn( name="odontologo_id")
    private Odontologo odontologo;

    public Turno() {
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
}
