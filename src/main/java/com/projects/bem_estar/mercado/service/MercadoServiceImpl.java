package com.projects.bem_estar.mercado.service;

import com.projects.bem_estar.endereco.model.Endereco;
import com.projects.bem_estar.endereco.service.EnderecoServiceImpl;
import com.projects.bem_estar.mercado.model.Mercado;
import com.projects.bem_estar.mercado.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercadoServiceImpl implements MercadoService {

    private final MercadoRepository mercadoRepository;
    private final EnderecoServiceImpl enderecoService;

    @Autowired
    public MercadoServiceImpl(MercadoRepository mercadoRepository, EnderecoServiceImpl enderecoService) {
        this.mercadoRepository = mercadoRepository;
        this.enderecoService = enderecoService;
    }

    @Override
    public List<Mercado> getAllMercados() {
        return mercadoRepository.findAll();
    }

    @Override
    public Mercado getMercadoById(Long id) {
        return mercadoRepository.findById(id).orElse(null);
    }
    @Override
    public Mercado getMercadoByCnpj(String cnpj) {
        return mercadoRepository.findByCnpj(cnpj);
    }
    @Override
    public Mercado createMercado(Mercado mercado) {
        Endereco enderecoExistente = enderecoService.getById(mercado.getEndereco().getId());
        if (enderecoExistente != null) {
            // Crie o Mercado e associe-o ao Endereco recuperado
            return mercadoRepository.save
                    (new Mercado(
                            mercado.getName(), mercado.getCnpj() ,mercado.getEmail(), enderecoExistente,mercado.getNum_telefone(), mercado.getPassword()
            ));
        } else {
            // Caso endereço não exista no banco
            enderecoService.createEndereco(mercado.getEndereco());
            return mercadoRepository.save(mercado);
        }
    }
    @Override
    public Mercado updateMercado(Long id, Mercado mercado) {
        Mercado existingMercado = getMercadoById(id);
        if (existingMercado!=null) {
            existingMercado.setName(mercado.getName());
            existingMercado.setEmail(mercado.getEmail());
            existingMercado.setNum_telefone(mercado.getNum_telefone());
            existingMercado.setPassword(mercado.getPassword());
            return mercadoRepository.save(existingMercado);
        }
        return null;
    }
    @Override
    public Mercado updateMercadoEndereco(Long id, Mercado mercado) {
        Mercado existingMercado = getMercadoById(id);
        if (existingMercado!=null) {
            existingMercado.setEndereco(enderecoService.createEndereco(mercado.getEndereco()));
            return mercadoRepository.save(existingMercado);
        }
        return null;
    }

    @Override
    public void deleteMercadoById(Long id) {
        mercadoRepository.deleteById(id);
    }
}
