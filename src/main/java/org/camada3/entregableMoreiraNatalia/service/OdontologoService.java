package org.camada3.entregableMoreiraNatalia.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camada3.entregableMoreiraNatalia.dto.OdontologoDto;
import org.camada3.entregableMoreiraNatalia.entity.Odontologo;
import org.camada3.entregableMoreiraNatalia.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IPersonaService<OdontologoDto> {


    private IOdontologoRepository odontologoRepository;
    private ObjectMapper mapper;

    @Autowired
    public void setObjectMapper ( ObjectMapper mapper){
        this.mapper = mapper;
    }

    @Autowired
    public void setIOdontologoRepository( IOdontologoRepository odontologoRepository ){
        this.odontologoRepository = odontologoRepository;
    }


    @Override
    public OdontologoDto crear(OdontologoDto odontologo) throws ServiceException {
        Odontologo entidad = null;

        if(!(String.valueOf(odontologo.getMatricula()).isBlank()))
            entidad = guardar( odontologo );
        else
            throw new ServiceException("No se puede guardar un odontólogo sin matrícula");

        return mapper.convertValue(entidad, OdontologoDto.class);
    }

    @Override
    public OdontologoDto buscarPorId(Integer id) throws ServiceException{
        Optional<Odontologo> encuentra = odontologoRepository.findById(id);
        if(encuentra.isPresent())
            return mapper.convertValue(encuentra, OdontologoDto.class);
        else
            throw new ServiceException("No existe el odontólogo buscado");
    }

    @Override
    public void modificar(OdontologoDto odontologo) {
        guardar(odontologo);
    }

    @Override
    public void eliminar(Integer id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Collection<OdontologoDto> listar() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDto> todos = new HashSet<>();
        for( Odontologo odontologo: odontologos)
            todos.add(mapper.convertValue(odontologo, OdontologoDto.class));
        return todos;
    }

    @Override
    public Set<OdontologoDto> buscarPorApellido(String apellido) {
        Set<Odontologo> todosConApellido = odontologoRepository.buscarPorApellido(apellido);
        Set<OdontologoDto> resultado = new HashSet<>();
        for( Odontologo o: todosConApellido)
            resultado.add(mapper.convertValue(o, OdontologoDto.class));
        return resultado;

    }

    private Odontologo guardar( OdontologoDto o){
        Odontologo odontologo = mapper.convertValue(o, Odontologo.class);
        return odontologoRepository.save(odontologo);
    }
}
