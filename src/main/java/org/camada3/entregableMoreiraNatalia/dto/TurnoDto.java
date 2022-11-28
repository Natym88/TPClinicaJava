package org.camada3.entregableMoreiraNatalia.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class TurnoDto implements Serializable {

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
    public String toString(){
        return "Turno: " + fecha.toString() + " Dr/Dra: " + odontologo.toString() + " Paciente: " + paciente.toString();
    }

    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
