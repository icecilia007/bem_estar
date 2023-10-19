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
    PlanoAlimentar createPlanoAlimentar(PlanoAlimentar planoAlimentar);
    PlanoAlimentar updatePlanoAlimentarStatus(Long id, String status);
    void deletePlanoAlimentar(Long id);
    PlanoAlimentar updatePlanoAlimentar(PlanoAlimentar planoAlimentar);
}
