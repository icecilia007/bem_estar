package com.projects.bem_estar.service;

import com.projects.bem_estar.models.Orcamento;

import java.util.List;

public interface OrcamentoService {
    List<Orcamento> getAllOrcamentos();

    Orcamento getOrcamentoById(Long idMercado, Long idPlanoAlimentar);
    List<Orcamento> getOrcamentosByStatus(String status);
    List<Orcamento> getOrcamentosByPlanoAlimentarId(Long planoAlimentarId);

    Orcamento createOrcamento(Orcamento orcamento);

    Orcamento updateOrcamento(Long idMercado, Long idPlanoAlimentar, Orcamento orcamento);

    void deleteOrcamento(Long id);

    List<Orcamento> getOrcamentosByPlanoAlimentar(Long idPlanoAlimentar);

    List<Orcamento> getOrcamentosByMercado(Long idMercado);
}
