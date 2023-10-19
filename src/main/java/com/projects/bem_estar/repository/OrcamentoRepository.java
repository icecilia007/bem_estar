package com.projects.bem_estar.repository;

import com.projects.bem_estar.models.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
    @Query("SELECT o FROM Orcamento o WHERE o.mercado_idMercado = :idMercado AND o.PlanoAlimentar_idPlanoAlimentar = :idPlanoAlimentar")
    Optional<Orcamento> findByPks(@Param("idMercado") Long idMercado,@Param("idPlanoAlimentar") Long idPlanoAlimentar);
    @Query("SELECT o FROM Orcamento o WHERE o.status = :status")
    List<Orcamento> findByStatus(@Param("status") String status);
    @Query("SELECT o FROM Orcamento o WHERE o.PlanoAlimentar_idPlanoAlimentar = :PlanoAlimentar_idPlanoAlimentar")
    List<Orcamento> findByPlanoAlimentarId(@Param("PlanoAlimentar_idPlanoAlimentar")Long planoAlimentarId);
    @Query("SELECT o FROM Orcamento o WHERE o.mercado_idMercado = :idMercado")
    List<Orcamento> findByMercado(@Param("idMercado") Long idMercado);
}
