package com.projects.bem_estar.controllers;

import com.projects.bem_estar.models.Ingrediente;
import com.projects.bem_estar.models.PlanoAlimentar;
import com.projects.bem_estar.service.PlanoAlimentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planosalimentares")
public class PlanoAlimentarController {

    private final PlanoAlimentarService planoAlimentarService;

    @Autowired
    public PlanoAlimentarController(PlanoAlimentarService planoAlimentarService) {
        this.planoAlimentarService = planoAlimentarService;
    }

    @GetMapping
    public ResponseEntity<List<PlanoAlimentar>> getAllPlanosAlimentares() {
        List<PlanoAlimentar> planosAlimentares = planoAlimentarService.getAllPlanosAlimentares();
        return new ResponseEntity<>(planosAlimentares, HttpStatus.OK);
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<PlanoAlimentar>> getAllPlanosAlimentares(@PathVariable String status) {
        List<PlanoAlimentar> planosAlimentares = planoAlimentarService.getAllPlanosAlimentares(status);
        return new ResponseEntity<>(planosAlimentares, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoAlimentar> getPlanoAlimentarById(@PathVariable Long id) {
        PlanoAlimentar planoAlimentar = planoAlimentarService.getPlanoAlimentarById(id);
        if (planoAlimentar != null) {
            return new ResponseEntity<>(planoAlimentar, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PlanoAlimentar>> getPlanosAlimentaresByClienteId(@PathVariable Long clienteId) {
        List<PlanoAlimentar> planosAlimentares = planoAlimentarService.getPlanosAlimentaresByClienteId(clienteId);
        if (!planosAlimentares.isEmpty()) {
            return new ResponseEntity<>(planosAlimentares, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cliente/cpf/{cpf}")
    public ResponseEntity<List<PlanoAlimentar>> getPlanosAlimentaresByClienteCpf(@PathVariable String cpf) {
        List<PlanoAlimentar> planosAlimentares = planoAlimentarService.getPlanosAlimentaresByClienteCpf(cpf);
        if (!planosAlimentares.isEmpty()) {
            return new ResponseEntity<>(planosAlimentares, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/nutricionista/{nutricionistaId}")
    public ResponseEntity<List<PlanoAlimentar>> getPlanosAlimentaresByNutricionistaId(@PathVariable Long nutricionistaId) {
        List<PlanoAlimentar> planosAlimentares = planoAlimentarService.getPlanosAlimentaresByNutricionistaId(nutricionistaId);
        if (!planosAlimentares.isEmpty()) {
            return new ResponseEntity<>(planosAlimentares, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/mercado/{mercadoId}")
    public ResponseEntity<List<PlanoAlimentar>> getPlanosAlimentaresByMercadoId(@PathVariable Long mercadoId) {
        List<PlanoAlimentar> planosAlimentares = planoAlimentarService.getPlanosAlimentaresByMercadoId(mercadoId);
        if (!planosAlimentares.isEmpty()) {
            return new ResponseEntity<>(planosAlimentares, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/mercado/cnpj/{cnpj}")
    public ResponseEntity<List<PlanoAlimentar>> getPlanosAlimentaresByMercadoCnpj(@PathVariable String cnpj) {
        List<PlanoAlimentar> planosAlimentares = planoAlimentarService.getPlanosAlimentaresByMercadoCnpj(cnpj);
        if (!planosAlimentares.isEmpty()) {
            return new ResponseEntity<>(planosAlimentares, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<PlanoAlimentar> createPlanoAlimentar(@RequestBody PlanoAlimentar planoAlimentar) {
        PlanoAlimentar newPlanoAlimentar = planoAlimentarService.createPlanoAlimentar(planoAlimentar);
        if (newPlanoAlimentar != null) {
            return new ResponseEntity<>(newPlanoAlimentar, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/orcamento-valor/{id}")
    public ResponseEntity<PlanoAlimentar> updatePlanoAlimentarOrcamentoValores(@PathVariable Long id, @RequestParam("atual") Double valorAtual,@RequestParam("esperado") Double valorEsperado) {
        PlanoAlimentar updatedPlanoAlimentar = planoAlimentarService.updatePlanoAlimentarOrcamentoValores(id, valorAtual, valorEsperado);
        if (updatedPlanoAlimentar != null) {
            return new ResponseEntity<>(updatedPlanoAlimentar, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/status/{id}")
    public ResponseEntity<PlanoAlimentar> updatePlanoAlimentarStatus(@PathVariable Long id, @RequestParam("status") String status) {
        PlanoAlimentar updatedPlanoAlimentar = planoAlimentarService.updatePlanoAlimentarStatus(id, status);
        if (updatedPlanoAlimentar != null) {
            return new ResponseEntity<>(updatedPlanoAlimentar, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/adicionar-mercado/{id}")
    public ResponseEntity<PlanoAlimentar> adicionarMercadoPlanoAlimentar(@PathVariable Long id, @RequestParam("idMercado") Long mercadoId) {
        PlanoAlimentar planoAlimentarComMercado = planoAlimentarService.adicionarMercadoPlanoAlimentar(id, mercadoId);
        if (planoAlimentarComMercado != null) {
            return new ResponseEntity<>(planoAlimentarComMercado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanoAlimentar(@PathVariable Long id) {
        planoAlimentarService.deletePlanoAlimentar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*@PostMapping("/{id}/ingredientes")
    public ResponseEntity<PlanoAlimentar> adicionarIngredientesAoPlano(@PathVariable Long id, @RequestBody List<Ingrediente> ingredientes) {
        PlanoAlimentar planoAlimentar = planoAlimentarService.getPlanoAlimentarById(id);

        if (planoAlimentar != null) {
            for (Ingrediente ingrediente : ingredientes) {
                planoAlimentar.adicionarIngrediente(ingrediente);
            }
            PlanoAlimentar updatedPlanoAlimentar = planoAlimentarService.updatePlanoAlimentar(planoAlimentar);
            return new ResponseEntity<>(updatedPlanoAlimentar, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}/ingredientes")
    public ResponseEntity<PlanoAlimentar> removerIngredientesDoPlano(@PathVariable Long id, @RequestBody List<Ingrediente> ingredientes) {
        PlanoAlimentar planoAlimentar = planoAlimentarService.getPlanoAlimentarById(id);

        if (planoAlimentar != null) {
            for (Ingrediente ingrediente : ingredientes) {
                planoAlimentar.removerIngrediente(ingrediente);
            }
            PlanoAlimentar updatedPlanoAlimentar = planoAlimentarService.updatePlanoAlimentar(planoAlimentar);
            return new ResponseEntity<>(updatedPlanoAlimentar, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
*/}

