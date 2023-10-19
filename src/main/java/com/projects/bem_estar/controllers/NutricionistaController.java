package com.projects.bem_estar.controllers;

import com.projects.bem_estar.helpers.Login;
import com.projects.bem_estar.models.Mercado;
import com.projects.bem_estar.models.Nutricionista;
import com.projects.bem_estar.service.NutricionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nutricionistas")
@CrossOrigin(origins = "*")
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

    @GetMapping("/inscricao/{inscricao}")
    public ResponseEntity<Nutricionista> getNutricionistaById(@PathVariable String inscricao) {
        Nutricionista nutricionista = nutricionistaService.getNutricionistaByInscricao(inscricao);
        if (nutricionista != null) {
            return new ResponseEntity<>(nutricionista, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/regiao_crn/{regiao_crn}")
    public ResponseEntity<List<Nutricionista>> getNutricionistaByRegiao_crn(@PathVariable Long regiao_crn) {
        List<Nutricionista> nutricionistas = nutricionistaService.getNutricionistaByRegiao_crn(regiao_crn);
        if (nutricionistas != null) {
            return new ResponseEntity<>(nutricionistas, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*@GetMapping("/validate")
    public String validateNutricionista(@RequestParam String inscricao, @RequestParam Long regiaoCrn) {
        // Chame o método do serviço para validar a inscrição do nutricionista
        return nutricionistaService.getNutricionistaValidation(inscricao, regiaoCrn);
    }*/
    @PostMapping
    public ResponseEntity<Nutricionista> createNutricionista(@RequestBody Nutricionista nutricionista) {
        Nutricionista newNutricionista = nutricionistaService.createNutricionista(nutricionista);
        if (newNutricionista != null) {
            return new ResponseEntity<>(newNutricionista, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/login/")
    public ResponseEntity<Object> userLogin(@RequestBody Login login){
        Optional<Nutricionista> nutricionista = nutricionistaService.getLogin(login.getIdentificador(),login.getSenha());
        if(nutricionista.isEmpty()){
            return new ResponseEntity<>(login,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(nutricionista,HttpStatus.OK);
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
