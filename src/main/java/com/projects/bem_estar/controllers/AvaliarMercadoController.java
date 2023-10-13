package com.projects.bem_estar.controllers;

import com.projects.bem_estar.helpers.ErrorResponse;
import com.projects.bem_estar.models.AvaliarMercado;
import com.projects.bem_estar.service.AvaliarMercadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/AvaliarMercados")
@CrossOrigin(origins = "*")
public class AvaliarMercadoController {
    private final AvaliarMercadoService AvaliarMercadoService;

    public AvaliarMercadoController(AvaliarMercadoService AvaliarMercadoService) {
        this.AvaliarMercadoService = AvaliarMercadoService;
    }
    @GetMapping
    public ResponseEntity<List<AvaliarMercado>> getAllAvaliarMercado(){
        List<AvaliarMercado> AvaliarMercados = AvaliarMercadoService.getAllAvaliarMercado();
        return new ResponseEntity<>(AvaliarMercados, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AvaliarMercado> getAvaliarMercadoById(@PathVariable Long id){
        AvaliarMercado AvaliarMercado = AvaliarMercadoService.getAvaliarMercadoById(id);
        if(AvaliarMercado!=null) return new ResponseEntity<>(AvaliarMercado,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<?> createAvaliarMercado(@RequestBody AvaliarMercado AvaliarMercado){

        if(AvaliarMercado==null) return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        else if(AvaliarMercado.getMercado()==null || AvaliarMercado.getCliente()==null)
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"Mercado e/ou cliente nulo"), HttpStatus.BAD_REQUEST);

        AvaliarMercado newAvaliarMercado = AvaliarMercadoService.createAvaliarMercado(AvaliarMercado);
        if(newAvaliarMercado!=null)
            return new ResponseEntity<>(newAvaliarMercado,HttpStatus.OK);

        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAvaliarMercado(@PathVariable Long id, @RequestBody AvaliarMercado AvaliarMercado){

        if(AvaliarMercado==null) return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        else if(AvaliarMercado.getMercado()==null || AvaliarMercado.getCliente()==null)
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"Mercado e/ou cliente nulo"), HttpStatus.BAD_REQUEST);

        AvaliarMercado updateAvaliarMercado = AvaliarMercadoService.updateAvaliarMercado(id, AvaliarMercado);
        if(updateAvaliarMercado!=null)
            return new ResponseEntity<>(updateAvaliarMercado, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        AvaliarMercadoService.deleteAvaliarMercado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
