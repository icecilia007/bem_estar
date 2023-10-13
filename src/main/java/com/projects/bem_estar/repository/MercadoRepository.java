package com.projects.bem_estar.repository;

import com.projects.bem_estar.models.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Long> {
    Mercado findByCnpj(String cnpj);
    @Query(value = "SELECT * FROM mercado WHERE cnpj = :cnpj AND senha = :senha", nativeQuery = true)
    Optional<Mercado> findByLogin(@Param("cnpj")String cnpj,@Param("senha") String senha);
}
