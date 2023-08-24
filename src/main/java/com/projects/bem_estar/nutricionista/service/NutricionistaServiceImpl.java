package com.projects.bem_estar.nutricionista.service;

import com.projects.bem_estar.nutricionista.model.Nutricionista;
import com.projects.bem_estar.nutricionista.repository.NutricionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NutricionistaServiceImpl implements NutricionistaService {

    private final NutricionistaRepository nutricionistaRepository;

    @Autowired
    public NutricionistaServiceImpl(NutricionistaRepository nutricionistaRepository) {
        this.nutricionistaRepository = nutricionistaRepository;
    }

    @Override
    public List<Nutricionista> getAllNutricionistas() {
        return nutricionistaRepository.findAll();
    }

    @Override
    public Nutricionista getNutricionistaById(Long id) {
        Optional<Nutricionista> optionalNutricionista = nutricionistaRepository.findById(id);
        return optionalNutricionista.orElse(null);
    }

    @Override
    public Nutricionista createNutricionista(Nutricionista nutricionista) {
        try {
            return nutricionistaRepository.save(nutricionista);
        } catch (DataIntegrityViolationException ex) {
            return null;
        }
    }

    @Override
    public Nutricionista updateNutricionista(Long id, Nutricionista nutricionista) {
        Nutricionista existingNutricionista = getNutricionistaById(id);
        if (existingNutricionista != null) {
            existingNutricionista.setName(nutricionista.getName());
            existingNutricionista.setEmail(nutricionista.getEmail());
            existingNutricionista.setInscricao(nutricionista.getInscricao());
            existingNutricionista.setRegiao_crn(nutricionista.getRegiao_crn());
            existingNutricionista.setPassword(nutricionista.getPassword());
            return nutricionistaRepository.save(existingNutricionista);
        }
        return null;
    }

    @Override
    public void deleteNutricionista(Long id) {
        nutricionistaRepository.deleteById(id);
    }

    @Override
    public Nutricionista getNutricionistaByEmail(String email) {
        return nutricionistaRepository.findByEmail(email);
    }

    @Override
    public Nutricionista getNutricionistaByInscricao(String inscricao) {
        return nutricionistaRepository.findByInscricao(inscricao);
    }

    @Override
    public Nutricionista getNutricionistaByRegiao_crn(Long regiao_crn) {
        return nutricionistaRepository.findByRegiao_crn(regiao_crn);
    }
}