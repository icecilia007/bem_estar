package com.projects.bem_estar.endereco.repository;

import com.projects.bem_estar.endereco.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByBairro(String bairro);

    List<Endereco> findByUf(String uf);

    List<Endereco> findByCidade(String cidade);

    List<Endereco> findByEndereco(String endereco);
}

