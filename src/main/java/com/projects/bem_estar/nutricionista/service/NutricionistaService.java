package com.projects.bem_estar.nutricionista.service;

import com.projects.bem_estar.nutricionista.model.Nutricionista;

import java.util.List;

public interface NutricionistaService {
    List<Nutricionista> getAllNutricionistas();
    Nutricionista getNutricionistaById(Long id);
    Nutricionista createNutricionista(Nutricionista nutricionista);
    Nutricionista updateNutricionista(Long id, Nutricionista nutricionista);
    void deleteNutricionista(Long id);
    Nutricionista getNutricionistaByEmail(String email);
    Nutricionista getNutricionistaByInscricao(String inscricao);
    Nutricionista getNutricionistaByRegiao_crn(Long regiao_crn);
}
