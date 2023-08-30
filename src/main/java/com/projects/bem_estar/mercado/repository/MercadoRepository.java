package com.projects.bem_estar.mercado.repository;

import com.projects.bem_estar.mercado.model.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Long> {
    Mercado findByCnpj(String cnpj);
}
