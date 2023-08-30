package com.projects.bem_estar.mercado.service;

import com.projects.bem_estar.mercado.model.Mercado;
import com.projects.bem_estar.mercado.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercadoServiceImpl implements MercadoService {

    private final MercadoRepository mercadoRepository;

    @Autowired
    public MercadoServiceImpl(MercadoRepository mercadoRepository) {
        this.mercadoRepository = mercadoRepository;
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
        return mercadoRepository.save(mercado);
    }

    @Override
    public Mercado updateMercado(Long id, Mercado mercado) {
        Optional<Mercado> existingMercado = mercadoRepository.findById(id);
        if (existingMercado.isPresent()) {
            mercado.setId(id);
            return mercadoRepository.save(mercado);
        }
        return null; // ou lançar exceção se não existir o mercado com o ID especificado
    }

    @Override
    public void deleteMercadoById(Long id) {
        mercadoRepository.deleteById(id);
    }
}
