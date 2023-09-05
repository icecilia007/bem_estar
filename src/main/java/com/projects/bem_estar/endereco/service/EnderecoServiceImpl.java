package com.projects.bem_estar.endereco.service;

import com.projects.bem_estar.endereco.model.Endereco;
import com.projects.bem_estar.endereco.repository.EnderecoRepository;
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
        return enderecoRepository.findByUf(uf);
    }

    @Override
    public List<Endereco> getByCidade(String cidade) {
        return enderecoRepository.findByCidade(cidade);
    }

    @Override
    public List<Endereco> getByBairro(String bairro) {
        return enderecoRepository.findByBairro(bairro);
    }

    @Override
    public List<Endereco> getByEndereco(String endereco) {
        return enderecoRepository.findByEndereco(endereco);
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
            existingEndereco.setEndereco(endereco.getEndereco());
            existingEndereco.setBairro(endereco.getBairro());
//            existingEndereco.setCep(endereco.getCep());
//            existingEndereco.setTipoCep(endereco.getTipoCep());
            existingEndereco.setCidade(endereco.getCidade());
            existingEndereco.setComplemento(endereco.getComplemento());
            existingEndereco.setUf(endereco.getUf());
            existingEndereco.setCodigoIBGE(endereco.getCodigoIBGE());
            existingEndereco.setSubTipoCep(endereco.getSubTipoCep());
            return enderecoRepository.save(endereco);
        }
        return null;
    }

    @Override
    public void deleteEnderecoById(Long id) {
        enderecoRepository.deleteById(id);
    }
}

