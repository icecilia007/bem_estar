package com.projects.bem_estar.cliente.controller;

import com.projects.bem_estar.cliente.model.Cliente;
import com.projects.bem_estar.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.getClienteById(id);
        if(cliente!=null)return new ResponseEntity<>(cliente, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Cliente> getClienteByCpf(@PathVariable String cpf) {
        Cliente cliente = clienteService.getClienteByCpf(cpf);
        if(cliente!=null)return new ResponseEntity<>(cliente, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente newCliente = clienteService.createCliente(cliente);
        if(newCliente!=null)return new ResponseEntity<>(newCliente, HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente updatedCliente = clienteService.updateCliente(id, cliente);
        if(updatedCliente!=null) return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
        else return new ResponseEntity<>(updatedCliente, HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/cpf/{cpf}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable String cpf, @RequestBody Cliente cliente) {
        Cliente updatedCliente = clienteService.updateClienteByCpf(cpf, cliente);
        if(updatedCliente!=null) return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
        else return new ResponseEntity<>(updatedCliente, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}