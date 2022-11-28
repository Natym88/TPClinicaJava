package org.camada3.entregableMoreiraNatalia.controller;

import org.camada3.entregableMoreiraNatalia.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService service;

    @Autowired
    public void setService(TurnoService service) {
        this.service = service;
    }
}
