package org.camada3.entregableMoreiraNatalia.service;

import org.camada3.entregableMoreiraNatalia.exceptions.ServiceException;
import org.camada3.entregableMoreiraNatalia.model.dto.Dto;

import java.util.Collection;
import java.util.Set;

public interface IPersonaService<D extends Dto> {

    D crear(D persona) throws ServiceException;

    D buscarPorId( Integer id) throws Exception;

    void modificar (D persona);

    void eliminar( Integer id);

    Collection<D> listar ();

    Set<D> buscarPorApellido (String apellido);
}
