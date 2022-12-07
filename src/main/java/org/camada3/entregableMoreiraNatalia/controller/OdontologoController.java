package org.camada3.entregableMoreiraNatalia.controller;

import org.camada3.entregableMoreiraNatalia.dto.OdontologoDto;
import org.camada3.entregableMoreiraNatalia.service.OdontologoService;
import org.camada3.entregableMoreiraNatalia.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private OdontologoService service;

    @GetMapping("/{id}")
    public OdontologoDto buscarPorId (@PathVariable int id) throws  Exception{

            return service.buscarPorId(id);

    }

    @PostMapping("/nuevo")
    public ResponseEntity<Object> guardar(@RequestBody OdontologoDto odontologo){
        ResponseEntity<Object> respuesta = null;

        try {

            respuesta = ResponseEntity.ok(service.crear(odontologo));
        } catch (ServiceException e) {
            respuesta = ResponseEntity.badRequest().body(e.getMessage());
        }

        return respuesta;
    }

    @GetMapping ("/todos")
    public Collection<OdontologoDto> listar(){
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Integer id){
        service.eliminar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping ("/buscarPorApellido")
    public Collection<OdontologoDto> buscarPorApellido (@RequestParam String apellido){
        return service.buscarPorApellido(apellido);
    }

    @Autowired
    public void setService( OdontologoService service){
        this.service = service;
    }
}
