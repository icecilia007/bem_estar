package com.projects.bem_estar.service.serviceImpl;

import com.projects.bem_estar.models.Orcamento;
import com.projects.bem_estar.repository.OrcamentoRepository;
import com.projects.bem_estar.service.MercadoService;
import com.projects.bem_estar.service.OrcamentoService;
import com.projects.bem_estar.service.PlanoAlimentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoServiceImpl implements OrcamentoService {
    private final OrcamentoRepository orcamentoRepository;
    private final PlanoAlimentarService planoAlimentarService;
    private final MercadoService mercadoService;

    @Autowired
    public OrcamentoServiceImpl(OrcamentoRepository orcamentoRepository, PlanoAlimentarService planoAlimentarService, MercadoService mercadoService) {
        this.orcamentoRepository = orcamentoRepository;
        this.planoAlimentarService = planoAlimentarService;
        this.mercadoService = mercadoService;
    }

    @Override
    public List<Orcamento> getAllOrcamentos() {
        return orcamentoRepository.findAll();
    }

    @Override
    public Orcamento getOrcamentoById(Long idMercado, Long idPlanoAlimentar) {
        Optional<Orcamento> orcamentoOptional = orcamentoRepository.findByPks(idMercado, idPlanoAlimentar);
        return orcamentoOptional.orElse(null);
    }
    @Override
    public List<Orcamento> getOrcamentosByPlanoAlimentar(Long id) {
        return orcamentoRepository.findByPlanoAlimentarId(id);
    }
    @Override
    public List<Orcamento> getOrcamentosByMercado(Long id) {
        return orcamentoRepository.findByMercado(id);
    }
    @Override
    public List<Orcamento> getOrcamentosByStatus(String status) {
        return orcamentoRepository.findByStatus(status);
    }
    @Override
    public List<Orcamento> getOrcamentosByPlanoAlimentarId(Long planoAlimentarId) {
        return orcamentoRepository.findByPlanoAlimentarId(planoAlimentarId);
    }
    @Override
    public Orcamento createOrcamento(Orcamento orcamento) {
        // Verifies if PlanoAlimentar and Mercado exist
        if (planoAlimentarService.getPlanoAlimentarById(orcamento.getPlanoAlimentar().getIdPlanoAlimentar()) != null
                && mercadoService.getMercadoById(orcamento.getMercado().getIdMercado()) != null) {
            return orcamentoRepository.save(orcamento);
        }
        return null;
    }

    @Override
    public Orcamento updateOrcamento(Long idMercado, Long idPlanoAlimentar, Orcamento orcamento) {
        Optional<Orcamento> orcamentoOptional = orcamentoRepository.findByPks(idMercado,idPlanoAlimentar);
        if (orcamentoOptional.isPresent()) {
            return orcamentoRepository.save(orcamento);
        }
        return null;
    }

    @Override
    public void deleteOrcamento(Long id) {
        orcamentoRepository.deleteById(id);
    }
}
