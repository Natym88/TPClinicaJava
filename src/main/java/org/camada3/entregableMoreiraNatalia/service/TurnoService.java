package org.camada3.entregableMoreiraNatalia.service;

import org.camada3.entregableMoreiraNatalia.configuration.MapperConfig;
import org.camada3.entregableMoreiraNatalia.exceptions.ServiceException;
import org.camada3.entregableMoreiraNatalia.model.dto.TurnoDto;
import org.camada3.entregableMoreiraNatalia.persistence.entity.Odontologo;
import org.camada3.entregableMoreiraNatalia.persistence.entity.Paciente;
import org.camada3.entregableMoreiraNatalia.persistence.entity.Turno;
import org.camada3.entregableMoreiraNatalia.persistence.repository.IOdontologoRepository;
import org.camada3.entregableMoreiraNatalia.persistence.repository.IPacienteRepository;
import org.camada3.entregableMoreiraNatalia.persistence.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TurnoService implements ITurnoService<TurnoDto>{

    private IPacienteRepository pacienteRepository;
    private IOdontologoRepository odontologoRepository;
    private ITurnoRepository turnoRepository;
    private MapperConfig mapper;
    @Autowired
    public void setPacienteService ( IPacienteRepository repository){
        this.pacienteRepository = repository;
    }
    @Autowired
    public void setOdontologoService (IOdontologoRepository repository){
        this.odontologoRepository = repository;
    }
    @Autowired
    public void setTurnoRepository (ITurnoRepository turnoRepository){
        this.turnoRepository = turnoRepository;
    }
    @Autowired
    public void setMapper ( MapperConfig mapper){
        this.mapper = mapper;
    }

    @Override
    public TurnoDto guardar(TurnoDto turnoNuevo) throws ServiceException {
        Optional<Paciente> paciente = pacienteRepository.findById(turnoNuevo.getPaciente().getId());
        Optional<Odontologo> odontologo = odontologoRepository.findById(turnoNuevo.getOdontologo().getId());
        if(!paciente.isPresent())
            throw new ServiceException("No existe el paciente");
        if(!odontologo.isPresent())
            throw new ServiceException("No existe el odontologo");
        if(turnoNuevo.getFecha().isBefore(LocalDate.now()) || turnoNuevo.getFecha().isEqual(LocalDate.now()))
            throw new ServiceException("No se puede pedir un turno anterior a la fecha actual");

        Turno entidad = mapper.objectMapper().convertValue(turnoNuevo, Turno.class);
        turnoRepository.save(entidad);
        entidad.setOdontologo(odontologo.get());
        entidad.setPaciente(paciente.get());
        TurnoDto turno = mapper.objectMapper().convertValue(entidad,TurnoDto.class);
        return turno;
    }

    @Override
    public Collection<TurnoDto> listar(){
        List<Turno> turnos = turnoRepository.findAll();
        Collection<TurnoDto> resultado = new HashSet<>();
        for(Turno t: turnos)
            resultado.add(mapper.objectMapper().convertValue(t, TurnoDto.class));
        return resultado;
    }

    @Override
    public void eliminar(Integer id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Collection<TurnoDto> buscarPorOdontologo(String apellidoOdontologo) {
        /*Set<OdontologoDto> odontologosEncontrados = mapper.objectMapper().convertValue(odontologoRepository.buscarPorApellido(apellidoOdontologo), OdontologoDto.class);
        Set<TurnoDto> resultado = new HashSet<>();
        for(OdontologoDto o: odontologosEncontrados){
            List<Turno> turnos =turnoRepository.findAll();
            turnos.toArray();
            turnos.stream().filter(turno -> turno.getOdontologo() == mapper.objectMapper().convertValue(o, Odontologo.class));


        }*/
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

    private Turno guardarInterno(Turno turno){
        return turnoRepository.save(turno);
    }



}
