package com.projects.bem_estar.controllers;

import com.projects.bem_estar.helpers.ErrorResponse;
import com.projects.bem_estar.models.AvaliarMercado;
import com.projects.bem_estar.service.AvaliarMercadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/avaliarentregas")
@CrossOrigin(origins = "*")
public class AvaliarMercadoController {
    private final AvaliarMercadoService avaliarEntregaService;

    public AvaliarMercadoController(AvaliarMercadoService avaliarEntregaService) {
        this.avaliarEntregaService = avaliarEntregaService;
    }
    @GetMapping
    public ResponseEntity<List<AvaliarMercado>> getAllAvaliarEntrega(){
        List<AvaliarMercado> avaliarEntregas = avaliarEntregaService.getAllAvaliarEntrega();
        return new ResponseEntity<>(avaliarEntregas, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AvaliarMercado> getAvaliarEntregaById(@PathVariable Long id){
        AvaliarMercado avaliarEntrega = avaliarEntregaService.getAvaliarEntregaById(id);
        if(avaliarEntrega!=null) return new ResponseEntity<>(avaliarEntrega,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<?> createAvaliarEntrega(@RequestBody AvaliarMercado avaliarEntrega){

        if(avaliarEntrega==null) return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        else if(avaliarEntrega.getMercado()==null || avaliarEntrega.getCliente()==null)
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"Mercado e/ou cliente nulo"), HttpStatus.BAD_REQUEST);

        AvaliarMercado newAvaliarEntrega = avaliarEntregaService.createAvaliarEntrega(avaliarEntrega);
        if(newAvaliarEntrega!=null)
            return new ResponseEntity<>(newAvaliarEntrega,HttpStatus.OK);

        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAvaliarEntrega(@PathVariable Long id, @RequestBody AvaliarMercado avaliarEntrega){

        if(avaliarEntrega==null) return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        else if(avaliarEntrega.getMercado()==null || avaliarEntrega.getCliente()==null)
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"Mercado e/ou cliente nulo"), HttpStatus.BAD_REQUEST);

        AvaliarMercado updateAvaliarEntrega = avaliarEntregaService.updateAvaliarEntrega(id, avaliarEntrega);
        if(updateAvaliarEntrega!=null)
            return new ResponseEntity<>(updateAvaliarEntrega, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        avaliarEntregaService.deleteAvaliarEntrega(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
