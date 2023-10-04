package com.projects.bem_estar.service;

import com.projects.bem_estar.models.Endereco;

import java.util.List;

public interface EnderecoService {
    Endereco getById(Long id);

    List<Endereco> getByUF(String uf);

    List<Endereco> getByCidade(String cidade);

    List<Endereco> getByBairro(String bairro);

    List<Endereco> getByEndereco(String endereco);

    List<Endereco> getAllEnderecos();

    Endereco createEndereco(Endereco endereco);

    Endereco updateEndereco(Long id, Endereco endereco);

    void deleteEnderecoById(int id);
}

