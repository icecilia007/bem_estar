package com.projects.bem_estar.service.serviceImpl;

import com.projects.bem_estar.models.Cliente;
import com.projects.bem_estar.models.Mercado;
import com.projects.bem_estar.models.PlanoAlimentar;
import com.projects.bem_estar.repository.ClienteRepository;
import com.projects.bem_estar.repository.MercadoRepository;
import com.projects.bem_estar.repository.PlanoAlimentarRepository;
import com.projects.bem_estar.service.PlanoAlimentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class PlanoAlimentarServiceImpl implements PlanoAlimentarService {
    private final PlanoAlimentarRepository planoAlimentarRepository;
    private final ClienteRepository clienteRepository;
    private final MercadoRepository mercadoRepository;
    @Autowired
    public PlanoAlimentarServiceImpl(PlanoAlimentarRepository planoAlimentarRepository, ClienteRepository clienteRepository, MercadoRepository mercadoRepository) {
        this.planoAlimentarRepository = planoAlimentarRepository;
        this.clienteRepository = clienteRepository;
        this.mercadoRepository = mercadoRepository;
    }
    @Override
    public List<PlanoAlimentar> getAllPlanosAlimentares() {
        return planoAlimentarRepository.findAll();
    }

    @Override
    public List<PlanoAlimentar> getAllPlanosAlimentaresByStatus(String status) {
        return planoAlimentarRepository.findByStatus(status);
    }

    @Override
    public PlanoAlimentar getPlanoAlimentarById(Long id) {
        return planoAlimentarRepository.findById(id).orElse(null);
    }

    @Override
    public List<PlanoAlimentar> getPlanosAlimentaresByClienteId(Long clienteId) {
        return planoAlimentarRepository.findByClienteId(clienteId);
    }

    @Override
    public List<PlanoAlimentar> getPlanosAlimentaresByClienteCpf(String cpf) {
        //Buscar o cliente com base no CPF
        Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
        if (cliente.isEmpty()) {
            return Collections.emptyList();
        }
        return planoAlimentarRepository.findByClienteId(cliente.get().getIdCliente());
    }

    @Override
    public List<PlanoAlimentar> getPlanosAlimentaresByNutricionistaId(Long nutricionistaId) {
        return planoAlimentarRepository.findByNutricionistaId(nutricionistaId);
    }

    @Override
    public PlanoAlimentar createPlanoAlimentar(PlanoAlimentar planoAlimentar) {
        return planoAlimentarRepository.save(planoAlimentar);
    }

    @Override
    public PlanoAlimentar updatePlanoAlimentarStatus(Long id, String status) {
        PlanoAlimentar planoAlimentar = planoAlimentarRepository.findById(id).orElse(null);
        if (planoAlimentar != null) {
            planoAlimentar.setStatus(status);
            return planoAlimentarRepository.save(planoAlimentar);
        }
        return null;
    }
    @Override
    public void deletePlanoAlimentar(Long id) {
        planoAlimentarRepository.deleteById(id);
    }

    @Override
    public PlanoAlimentar updatePlanoAlimentar(PlanoAlimentar planoAlimentar) {
        return null;
    }
}
