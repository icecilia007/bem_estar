package com.projects.bem_estar.service.serviceImpl;

import com.projects.bem_estar.helpers.NutricionistaRequest;
import com.projects.bem_estar.helpers.Option;
import com.projects.bem_estar.models.Nutricionista;
import com.projects.bem_estar.repository.NutricionistaRepository;
import com.projects.bem_estar.service.NutricionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class NutricionistaServiceImpl implements NutricionistaService {

    private static final String CNN_API_URL = "https://cnn.cfn.org.br/application/front-resource/get";
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
    public List<Nutricionista> getNutricionistaByRegiao_crn(Long regiao_crn) {
        return nutricionistaRepository.findByRegiao_crn(regiao_crn);
    }

    public String getNutricionistaValidation(String inscricao, Long regiaoCrn) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        NutricionistaRequest request = new NutricionistaRequest();
        request.setComando("get-nutricionista");
        Option option = new Option();
        option.setNome("Jacira Cristine");
        option.setCrn(String.valueOf(regiaoCrn));
        option.setRegistro(inscricao);
        option.setGeral(true);

        request.setOptions(option);

        HttpEntity<NutricionistaRequest> entity = new HttpEntity<>(request, headers);

        RestTemplate restTemplate = new RestTemplate();
        System.out.println("\n\n\n" + entity);
        ResponseEntity<String> response = restTemplate.exchange(CNN_API_URL, HttpMethod.POST, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String responseBody = response.getBody();
            return "OK"; // Substitua isso com a lógica apropriada.
        } else {
            return "Erro ao consultar a API do CNN CFN";
        }
    }

    @Override
    public Optional<Nutricionista> getLogin(String email, String senha) {
        return nutricionistaRepository.findByLogin(email,senha);
    }
}