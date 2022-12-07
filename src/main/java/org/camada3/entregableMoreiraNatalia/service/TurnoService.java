package org.camada3.entregableMoreiraNatalia.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camada3.entregableMoreiraNatalia.dto.OdontologoDto;
import org.camada3.entregableMoreiraNatalia.dto.PacienteDto;
import org.camada3.entregableMoreiraNatalia.dto.PedirTurnoDto;
import org.camada3.entregableMoreiraNatalia.dto.TurnoDto;
import org.camada3.entregableMoreiraNatalia.entity.Odontologo;
import org.camada3.entregableMoreiraNatalia.entity.Paciente;
import org.camada3.entregableMoreiraNatalia.entity.Turno;
import org.camada3.entregableMoreiraNatalia.repository.IOdontologoRepository;
import org.camada3.entregableMoreiraNatalia.repository.IPacienteRepository;
import org.camada3.entregableMoreiraNatalia.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TurnoService implements ITurnoService<TurnoDto>{

    private PacienteService pacienteService;
    private OdontologoService odontologoService;
    private ITurnoRepository turnoRepository;
    private ObjectMapper mapper;
    @Autowired
    public void setPacienteService ( PacienteService service){
        this.pacienteService = service;
    }
    @Autowired
    public void setOdontologoService (OdontologoService service){
        this.odontologoService = service;
    }
    @Autowired
    public void setTurnoRepository (ITurnoRepository turnoRepository){
        this.turnoRepository = turnoRepository;
    }
    @Autowired
    public void setMapper ( ObjectMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public TurnoDto guardar(PedirTurnoDto turnoNuevo) throws ServiceException {

        Turno entidad = null;
        TurnoDto turno;
        PacienteDto pacienteDto;
        OdontologoDto odontologoDto;

        if(!turnoNuevo.getFecha().isBefore(LocalDate.now())) {
            try {
                pacienteDto = pacienteService.buscarPorId(turnoNuevo.getPacienteId());
                entidad.setPaciente(mapper.convertValue(pacienteDto, Paciente.class));
            } catch (ServiceException e) {
                throw new ServiceException(e.getMessage());
            }
            try {
                odontologoDto = odontologoService.buscarPorId(turnoNuevo.getOdontologoId());
                entidad.setOdontologo(mapper.convertValue(odontologoDto, Odontologo.class));
            } catch (ServiceException e) {
                throw new ServiceException(e.getMessage());
            }

            entidad.setFecha(turnoNuevo.getFecha());
            Turno guardado = guardarInterno(entidad);
            turno = mapper.convertValue(guardado,TurnoDto.class);
            if(odontologoDto != null)
                odontologoDto.getTurnos().add(turno);

        } else
            throw new ServiceException("No se puede crear un turno con fecha anterior al día de la fecha");

        return turno;
    }

    @Override
    public void eliminar(Integer id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Collection<TurnoDto> buscarPorOdontologo(String apellidoOdontologo) {
        Set<OdontologoDto> odontologosEncontrados = odontologoService.buscarPorApellido(apellidoOdontologo);
        Set<TurnoDto> resultado = new HashSet<>();
        for(OdontologoDto o: odontologosEncontrados){
            List<Turno> turnos =turnoRepository.findAll();
            turnos.toArray();
            turnos.stream().filter(turno -> turno.getOdontologo() == mapper.convertValue(o, Odontologo.class));


        }
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
