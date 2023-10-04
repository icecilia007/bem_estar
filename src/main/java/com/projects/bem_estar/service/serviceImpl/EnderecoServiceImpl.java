package com.projects.bem_estar.service.serviceImpl;

import com.projects.bem_estar.models.Endereco;
import com.projects.bem_estar.repository.EnderecoRepository;
import com.projects.bem_estar.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Endereco getById(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Endereco> getByUF(String uf) {
        return enderecoRepository.findByEstado(uf);
    }

    @Override
    public List<Endereco> getByCidade(String cidade) {
        return enderecoRepository.findByCidade(cidade);
    }

    @Override
    public List<Endereco> getByBairro(String bairro) {
        return enderecoRepository.findByVizinha(bairro);
    }

    @Override
    public List<Endereco> getByEndereco(String endereco) {
        return enderecoRepository.findByRua(endereco);
    }

    @Override
    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco createEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco updateEndereco(Long id, Endereco endereco) {
        Endereco existingEndereco = getById(id);
        if (existingEndereco != null) {
            existingEndereco.setRua(endereco.getRua());
            existingEndereco.setVizinha(endereco.getVizinha());
//            existingEndereco.setCep(endereco.getCep());
//            existingEndereco.setTipoCep(endereco.getTipoCep());
            existingEndereco.setCidade(endereco.getCidade());
            existingEndereco.setServico(endereco.getServico());
            existingEndereco.setEstado(endereco.getEstado());
            return enderecoRepository.save(endereco);
        }
        return null;
    }

    @Override
    public void deleteEnderecoById(int id) {
        enderecoRepository.deleteById((long) id);
    }
}

