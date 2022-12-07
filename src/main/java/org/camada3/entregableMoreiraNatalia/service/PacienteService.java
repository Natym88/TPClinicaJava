package org.camada3.entregableMoreiraNatalia.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camada3.entregableMoreiraNatalia.dto.OdontologoDto;
import org.camada3.entregableMoreiraNatalia.dto.PacienteDto;
import org.camada3.entregableMoreiraNatalia.entity.Odontologo;
import org.camada3.entregableMoreiraNatalia.entity.Paciente;
import org.camada3.entregableMoreiraNatalia.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PacienteService implements IPersonaService<PacienteDto>{

    private IPacienteRepository pacienteRepository;
    private ObjectMapper mapper;

    @Autowired
    public void setObjectMapper ( ObjectMapper mapper){
        this.mapper = mapper;
    }

    @Autowired
    public void setIPacienteRepository( IPacienteRepository pacienteRepository ){
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public PacienteDto crear(PacienteDto paciente) throws ServiceException {

        Paciente entidad = null;

        if(!(String.valueOf(paciente.getDni()).isBlank())){
            paciente.setFechaAlta(LocalDate.now());
            entidad = guardar(paciente);}
        else
            throw new ServiceException("No se puede guardar un paciente sin DNI");

        return mapper.convertValue(entidad, PacienteDto.class);
    }

    @Override
    public PacienteDto buscarPorId(Integer id) throws ServiceException {
        Optional<Paciente> encuentra = pacienteRepository.findById(id);
        if(encuentra.isPresent())
            return mapper.convertValue(encuentra, PacienteDto.class);
        else
            throw new ServiceException ("No existe el paciente buscado");
    }

    @Override
    public void modificar(PacienteDto paciente) {
        guardar(paciente);
    }

    @Override
    public void eliminar(Integer id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Collection<PacienteDto> listar() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDto> resultado = new HashSet<>();
        for(Paciente p: pacientes)
            resultado.add(mapper.convertValue(p,PacienteDto.class));
        return resultado;
    }

    @Override
    public Set<PacienteDto> buscarPorApellido(String apellido) {
        return null;
    }

    private Paciente guardar( PacienteDto paciente){
        Paciente paciente1 = mapper.convertValue(paciente, Paciente.class);
        return pacienteRepository.save(paciente1);
    }
}
