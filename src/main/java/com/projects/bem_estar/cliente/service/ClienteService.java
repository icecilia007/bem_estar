package com.projects.bem_estar.cliente.service;

import com.projects.bem_estar.cliente.model.Cliente;

import java.util.List;

public interface ClienteService {
        List<Cliente> getAllClientes();
        Cliente getClienteById(Long id);
        Cliente createCliente(Cliente cliente);
        Cliente updateCliente(Long id, Cliente cliente);
        Cliente deleteCliente(Long id);

}
