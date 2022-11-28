package org.camada3.entregableMoreiraNatalia.service;

import org.camada3.entregableMoreiraNatalia.dto.OdontologoDto;
import org.camada3.entregableMoreiraNatalia.dto.PacienteDto;

import java.util.Collection;
import java.util.Set;

public interface IPacienteService {

    void crear(PacienteDto paciente);
    PacienteDto buscarPorId (Integer id) throws Exception;
    void modificar (PacienteDto paciente);
    void eliminar( Integer id);
    Collection<PacienteDto> listar();
    Set<PacienteDto> buscarPorApellido(String apellido);
}
