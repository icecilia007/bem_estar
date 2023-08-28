package com.projects.bem_estar.endereco.controller;

import com.projects.bem_estar.endereco.model.Endereco;
import com.projects.bem_estar.endereco.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable Long id) {
        return enderecoService.getById(id);
    }

    @GetMapping("/uf/{uf}")
    public List<Endereco> buscarPorUF(@PathVariable String uf) {
        return enderecoService.getByUF(uf);
    }

    @GetMapping("/cidade/{cidade}")
    public List<Endereco> buscarPorCidade(@PathVariable String cidade) {
        return enderecoService.getByCidade(cidade);
    }

    @GetMapping("/bairro/{bairro}")
    public List<Endereco> buscarPorBairro(@PathVariable String bairro) {
        return enderecoService.getByBairro(bairro);
    }

    @GetMapping("/endereco/{endereco}")
    public List<Endereco> buscarPorEndereco(@PathVariable String endereco) {
        return enderecoService.getByEndereco(endereco);
    }
    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        List<Endereco> enderecos = enderecoService.getAllEnderecos();
        return ResponseEntity.ok(enderecos);
    }

    @PostMapping
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco) {
        Endereco novoEndereco = enderecoService.createEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEndereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        Endereco updatedEndereco = enderecoService.updateEndereco(id, endereco);
        if (updatedEndereco != null) {
            return ResponseEntity.ok(updatedEndereco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnderecoById(@PathVariable Long id) {
        enderecoService.deleteEnderecoById(id);
        return ResponseEntity.noContent().build();
    }
}

