package org.camada3.entregableMoreiraNatalia.service;

import org.camada3.entregableMoreiraNatalia.dto.TurnoDto;

import java.util.Collection;
import java.util.Date;

public interface ITurnoService {

    void guardar(TurnoDto turno);
    void eliminar (Integer id);
    Collection<TurnoDto> buscarPorOdontologo(String apellidoOdontologo);
    Collection<TurnoDto> buscarPorPaciente(String apellidoPaciente);
    Collection<TurnoDto> buscarPorFecha(Date fecha);
    TurnoDto buscarPorId (Integer id) throws Exception;
    void modificar(TurnoDto turno);
}
