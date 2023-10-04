package com.projects.bem_estar.controllers;

import com.projects.bem_estar.models.Mercado;
import com.projects.bem_estar.service.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mercados")
public class MercadoController {

    private final MercadoService mercadoService;

    @Autowired
    public MercadoController(MercadoService mercadoService) {
        this.mercadoService = mercadoService;
    }

    @GetMapping
    public ResponseEntity<List<Mercado>> getAllMercados() {
        List<Mercado> mercados = mercadoService.getAllMercados();
        return new ResponseEntity<>(mercados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mercado> getMercadoById(@PathVariable Long id) {
        Mercado mercado = mercadoService.getMercadoById(id);
        if (mercado != null) {
            return new ResponseEntity<>(mercado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Mercado> getMercadoByCnpj(@PathVariable String cnpj) {
        Mercado mercado = mercadoService.getMercadoByCnpj(cnpj);
        if (mercado != null) {
            return new ResponseEntity<>(mercado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Mercado> createMercado(@RequestBody Mercado mercado) {
        Mercado newMercado = mercadoService.createMercado(mercado);
        if (newMercado != null) return new ResponseEntity<>(newMercado, HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mercado> updateMercado(@PathVariable Long id, @RequestBody Mercado mercado) {
        Mercado updatedMercado = mercadoService.updateMercado(id, mercado);
        if (updatedMercado != null) {
            return new ResponseEntity<>(updatedMercado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/endereco/{id}")
    public ResponseEntity<Mercado> updateMercadoEndereco(@PathVariable Long id, @RequestBody Mercado mercado) {
        Mercado updatedMercado = mercadoService.updateMercadoEndereco(id, mercado);
        if (updatedMercado != null) {
            return new ResponseEntity<>(updatedMercado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMercado(@PathVariable Long id) {
        mercadoService.deleteMercadoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}