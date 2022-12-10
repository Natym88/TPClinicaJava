package org.camada3.entregableMoreiraNatalia.controller;

import org.camada3.entregableMoreiraNatalia.model.dto.PacienteDto;
import org.camada3.entregableMoreiraNatalia.service.PacienteService;
import org.camada3.entregableMoreiraNatalia.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;

    @PostMapping("/nuevo")
    public ResponseEntity<Object> registrarPaciente(@RequestBody PacienteDto paciente) throws ServiceException {

        ResponseEntity<Object> respuesta = null;

            respuesta = ResponseEntity.ok(pacienteService.crear(paciente));


        return respuesta;
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificar(@RequestBody PacienteDto paciente) throws Exception {

        if (paciente.getId() != null && pacienteService.buscarPorId(paciente.getId()) != null)
        {   pacienteService.modificar(paciente);
            return ResponseEntity.ok(HttpStatus.OK);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/todos")
    public Collection<PacienteDto> listar(){
        return pacienteService.listar();
    }

    @GetMapping("{id}")
    public PacienteDto buscarPaciente(@PathVariable Integer id) throws Exception{
        return pacienteService.buscarPorId(id);
    }

    @Autowired
    public void setPacienteService( PacienteService service){
        this.pacienteService = service;
    }
}
