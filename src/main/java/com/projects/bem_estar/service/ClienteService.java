package com.projects.bem_estar.service;

import com.projects.bem_estar.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> getAllClientes();

    Cliente getClienteById(Long id);

    Cliente createCliente(Cliente cliente);

    Cliente updateCliente(Long id, Cliente cliente);

    Cliente deleteCliente(Long id);

    Cliente getClienteByCpf(String cpf);

    Cliente updateClienteByCpf(String cpf, Cliente cliente);

    Optional<Cliente> getLogin(String identificador, String senha);
}
