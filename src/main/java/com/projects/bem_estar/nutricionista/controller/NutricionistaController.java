package com.projects.bem_estar.nutricionista.controller;

import com.projects.bem_estar.nutricionista.model.Nutricionista;
import com.projects.bem_estar.nutricionista.service.NutricionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nutricionistas")
public class NutricionistaController {

    private final NutricionistaService nutricionistaService;

    @Autowired
    public NutricionistaController(NutricionistaService nutricionistaService) {
        this.nutricionistaService = nutricionistaService;
    }

    @GetMapping
    public ResponseEntity<List<Nutricionista>> getAllNutricionistas() {
        List<Nutricionista> nutricionistas = nutricionistaService.getAllNutricionistas();
        return new ResponseEntity<>(nutricionistas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nutricionista> getNutricionistaById(@PathVariable Long id) {
        Nutricionista nutricionista = nutricionistaService.getNutricionistaById(id);
        if (nutricionista != null) {
            return new ResponseEntity<>(nutricionista, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<Nutricionista> createNutricionista(@RequestBody Nutricionista nutricionista) {
        Nutricionista newNutricionista = nutricionistaService.createNutricionista(nutricionista);
        if (newNutricionista != null) {
            return new ResponseEntity<>(newNutricionista, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nutricionista> updateNutricionista(@PathVariable Long id, @RequestBody Nutricionista nutricionista) {
        Nutricionista updatedNutricionista = nutricionistaService.updateNutricionista(id, nutricionista);
        if (updatedNutricionista != null) {
            return new ResponseEntity<>(updatedNutricionista, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNutricionista(@PathVariable Long id) {
        nutricionistaService.deleteNutricionista(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
