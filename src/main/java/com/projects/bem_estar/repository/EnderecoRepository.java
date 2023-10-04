package com.projects.bem_estar.repository;

import com.projects.bem_estar.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByVizinha(String vizinha);

    List<Endereco> findByEstado(String uf);

    List<Endereco> findByCidade(String cidade);

    List<Endereco> findByRua(String endereco);
}

