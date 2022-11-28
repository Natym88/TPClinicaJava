package org.camada3.entregableMoreiraNatalia.service;

import org.camada3.entregableMoreiraNatalia.dto.TurnoDto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class TurnoService implements ITurnoService{
    @Override
    public void guardar(TurnoDto turno) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public Collection<TurnoDto> buscarPorOdontologo(String apellidoOdontologo) {
        return null;
    }

    @Override
    public Collection<TurnoDto> buscarPorPaciente(String apellidoPaciente) {
        return null;
    }

    @Override
    public Collection<TurnoDto> buscarPorFecha(Date fecha) {
        return null;
    }

    @Override
    public TurnoDto buscarPorId(Integer id) throws Exception {
        return null;
    }

    @Override
    public void modificar(TurnoDto turno) {

    }
}
