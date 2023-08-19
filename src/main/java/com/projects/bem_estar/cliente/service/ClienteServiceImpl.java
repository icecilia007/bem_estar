package com.projects.bem_estar.cliente.service;

import com.projects.bem_estar.cliente.model.Cliente;
import com.projects.bem_estar.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        return optionalCliente.orElse(null);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente existingCliente = getClienteById(id);
        if (existingCliente != null) {
            existingCliente.setName(cliente.getName());
            existingCliente.setEmail(cliente.getEmail());
            existingCliente.setCpf(cliente.getCpf());
            existingCliente.setPassword(cliente.getPassword());
            return clienteRepository.save(existingCliente);
        }
        return null;
    }

    @Override
    public Cliente deleteCliente(Long id) {
        clienteRepository.deleteById(id);
        return null;
    }
}