package com.projects.bem_estar.service;

import com.projects.bem_estar.models.PlanoAlimentar;

import java.util.List;

public interface PlanoAlimentarService {

    List<PlanoAlimentar> getAllPlanosAlimentares();
    List<PlanoAlimentar> getAllPlanosAlimentares(String status);

    PlanoAlimentar getPlanoAlimentarById(Long id);
    List<PlanoAlimentar> getPlanosAlimentaresByClienteId(Long clienteId);
    List<PlanoAlimentar> getPlanosAlimentaresByClienteCpf(String cpf);
    List<PlanoAlimentar> getPlanosAlimentaresByNutricionistaId(Long nutricionistaId);
    List<PlanoAlimentar> getPlanosAlimentaresByMercadoId(Long mercadoId);
    List<PlanoAlimentar> getPlanosAlimentaresByMercadoCnpj(String cnpj);
    PlanoAlimentar createPlanoAlimentar(PlanoAlimentar planoAlimentar);
    PlanoAlimentar updatePlanoAlimentarOrcamentoValores(Long id, Double valorAtual, Double valorEsperado);

    PlanoAlimentar updatePlanoAlimentarStatus(Long id, String status);

    PlanoAlimentar adicionarMercadoPlanoAlimentar(Long idPlanoAlimentar, Long idMercado);

    void deletePlanoAlimentar(Long id);

    PlanoAlimentar updatePlanoAlimentar(PlanoAlimentar planoAlimentar);
}
