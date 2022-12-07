package org.camada3.entregableMoreiraNatalia.controller;

import org.camada3.entregableMoreiraNatalia.dto.PedirTurnoDto;
import org.camada3.entregableMoreiraNatalia.dto.TurnoDto;
import org.camada3.entregableMoreiraNatalia.service.ServiceException;
import org.camada3.entregableMoreiraNatalia.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService service;

    @PostMapping("/nuevo")
    public ResponseEntity<Object> guardarTurno(@RequestBody PedirTurnoDto turno){
        ResponseEntity<Object> respuesta = null;

        try {
            respuesta = ResponseEntity.ok(service.guardar(turno));
        } catch (ServiceException e) {
            respuesta = ResponseEntity.badRequest().body(e.getMessage());
        }
        return respuesta;
    }

    @Autowired
    public void setService(TurnoService service) {
        this.service = service;
    }
}
