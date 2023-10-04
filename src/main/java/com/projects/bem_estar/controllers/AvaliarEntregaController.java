package com.projects.bem_estar.controllers;

import com.projects.bem_estar.helpers.ErrorResponse;
import com.projects.bem_estar.models.AvaliarEntrega;
import com.projects.bem_estar.service.AvaliarEntregaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/avaliarentregas")
@CrossOrigin(origins = "*")
public class AvaliarEntregaController {
    private final AvaliarEntregaService avaliarEntregaService;

    public AvaliarEntregaController(AvaliarEntregaService avaliarEntregaService) {
        this.avaliarEntregaService = avaliarEntregaService;
    }
    @GetMapping
    public ResponseEntity<List<AvaliarEntrega>> getAllAvaliarEntrega(){
        List<AvaliarEntrega> avaliarEntregas = avaliarEntregaService.getAllAvaliarEntrega();
        return new ResponseEntity<>(avaliarEntregas, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AvaliarEntrega> getAvaliarEntregaById(@PathVariable Long id){
        AvaliarEntrega avaliarEntrega = avaliarEntregaService.getAvaliarEntregaById(id);
        if(avaliarEntrega!=null) return new ResponseEntity<>(avaliarEntrega,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<?> createAvaliarEntrega(@RequestBody AvaliarEntrega avaliarEntrega){

        if(avaliarEntrega==null) return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        else if(avaliarEntrega.getMercado()==null || avaliarEntrega.getCliente()==null)
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"Mercado e/ou cliente nulo"), HttpStatus.BAD_REQUEST);

        AvaliarEntrega newAvaliarEntrega = avaliarEntregaService.createAvaliarEntrega(avaliarEntrega);
        if(newAvaliarEntrega!=null)
            return new ResponseEntity<>(newAvaliarEntrega,HttpStatus.OK);

        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAvaliarEntrega(@PathVariable Long id, @RequestBody AvaliarEntrega avaliarEntrega){

        if(avaliarEntrega==null) return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        else if(avaliarEntrega.getMercado()==null || avaliarEntrega.getCliente()==null)
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),"Mercado e/ou cliente nulo"), HttpStatus.BAD_REQUEST);

        AvaliarEntrega updateAvaliarEntrega = avaliarEntregaService.updateAvaliarEntrega(id, avaliarEntrega);
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
