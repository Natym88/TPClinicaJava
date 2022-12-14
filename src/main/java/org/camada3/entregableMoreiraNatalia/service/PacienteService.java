package org.camada3.entregableMoreiraNatalia.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camada3.entregableMoreiraNatalia.dto.PacienteDto;
import org.camada3.entregableMoreiraNatalia.entity.Paciente;
import org.camada3.entregableMoreiraNatalia.repository.IOdontologoRepository;
import org.camada3.entregableMoreiraNatalia.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService{

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
    public void crear(PacienteDto paciente) {
        guardar(paciente);
    }

    @Override
    public PacienteDto buscarPorId(Integer id) throws Exception {
        Optional<Paciente> encuentra = pacienteRepository.findById(id);
        if(encuentra.isPresent())
            return mapper.convertValue(encuentra, PacienteDto.class);
        else
            throw new Exception ("No existe el paciente buscado");
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

    private void guardar( PacienteDto paciente){
        Paciente paciente1 = mapper.convertValue(paciente, Paciente.class);
        pacienteRepository.save(paciente1);
    }
}
