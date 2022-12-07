package org.camada3.entregableMoreiraNatalia.dto;

import java.time.LocalDate;

public class PedirTurnoDto implements Dto {

    private Integer id;
    private Integer odontologoId;
    private Integer pacienteId;

    public PedirTurnoDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(Integer odontologoId) {
        this.odontologoId = odontologoId;
    }

    public Integer getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    private LocalDate fecha;
}
