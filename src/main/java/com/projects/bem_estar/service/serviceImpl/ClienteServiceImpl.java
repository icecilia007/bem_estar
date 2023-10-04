package com.projects.bem_estar.service.serviceImpl;

import com.projects.bem_estar.models.Cliente;
import com.projects.bem_estar.repository.ClienteRepository;
import com.projects.bem_estar.models.Endereco;
import com.projects.bem_estar.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final EnderecoServiceImpl enderecoService;


    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, EnderecoServiceImpl enderecoService) {
        this.clienteRepository = clienteRepository;
        this.enderecoService = enderecoService;
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
        Endereco enderecoExistente = enderecoService.getById(cliente.getEndereco().getIdEndereco());
        if (enderecoExistente != null) {
            // Crie o Mercado e associe-o ao Endereco recuperado
            return clienteRepository.save
                    (new Cliente(cliente.getName(), cliente.getEmail(), cliente.getCpf(), cliente.getSenha(),enderecoExistente
                    ));
        }else{
            enderecoService.createEndereco(cliente.getEndereco());
            return clienteRepository.save(cliente);
        }
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente existingCliente = getClienteById(id);
        if (existingCliente != null) {
            existingCliente.setName(cliente.getName());
            existingCliente.setEmail(cliente.getEmail());
            existingCliente.setSenha(cliente.getSenha());
            return clienteRepository.save(existingCliente);
        }
        return null;
    }
    @Override
    public Cliente deleteCliente(Long id) {
        clienteRepository.deleteById(id);
        return null;
    }

    @Override
    public Cliente getClienteByCpf(String cpf) {
        Optional<Cliente> optionalCliente = clienteRepository.findByCpf(cpf);
        return optionalCliente.orElse(null);
    }

    @Override
    public Cliente updateClienteByCpf(String cpf, Cliente cliente) {
        Cliente existingCliente = getClienteByCpf(cpf);
        if (existingCliente != null) {
            existingCliente.setName(cliente.getName());
            existingCliente.setEmail(cliente.getEmail());
            existingCliente.setSenha(cliente.getSenha());
            return clienteRepository.save(existingCliente);
        }
        return null;
    }
}