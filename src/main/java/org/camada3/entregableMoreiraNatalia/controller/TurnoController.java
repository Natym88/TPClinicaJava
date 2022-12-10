package org.camada3.entregableMoreiraNatalia.controller;

import org.camada3.entregableMoreiraNatalia.model.dto.TurnoDto;
import org.camada3.entregableMoreiraNatalia.exceptions.ServiceException;
import org.camada3.entregableMoreiraNatalia.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService service;

    @PostMapping("/nuevo")
    public ResponseEntity<Object> guardarTurno(@RequestBody TurnoDto turno) throws ServiceException {
        ResponseEntity<Object> respuesta = null;
        respuesta = ResponseEntity.ok(service.guardar(turno));

        return respuesta;
    }

    @GetMapping("{id}")
    public TurnoDto buscarPorId (Integer id) throws Exception{
        return service.buscarPorId(id);
    }

    @GetMapping("/todos")
    public Collection<TurnoDto> listar (){
        return service.listar();
    }

    @Autowired
    public void setService(TurnoService service) {
        this.service = service;
    }
}
