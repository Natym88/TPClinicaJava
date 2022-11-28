package org.camada3.entregableMoreiraNatalia.service;

import org.camada3.entregableMoreiraNatalia.dto.OdontologoDto;

import java.util.Collection;
import java.util.Set;

public interface IOdontologoService {

    public void crear(OdontologoDto odontologo);

    public OdontologoDto buscarPorId( Integer id) throws Exception;

    public void modificar (OdontologoDto odontologo);

    public void eliminar( Integer id);

    public Collection<OdontologoDto> listar ();

    public Set<OdontologoDto> buscarPorApellido (String apellido);
}
