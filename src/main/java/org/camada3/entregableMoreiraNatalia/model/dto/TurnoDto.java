package org.camada3.entregableMoreiraNatalia.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)

public class TurnoDto implements Dto {

    private Integer id;
    private OdontologoDto odontologo;
    private PacienteDto paciente;
    private LocalDate fecha;

    public TurnoDto() {}

    public TurnoDto(OdontologoDto odontologo, PacienteDto paciente, LocalDate fecha) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "TurnoDto{" +
                "id=" + id +
                ", odontologo=" + odontologo +
                ", paciente=" + paciente +
                ", fecha=" + fecha +
                '}';
    }


    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OdontologoDto getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(OdontologoDto odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }
}
