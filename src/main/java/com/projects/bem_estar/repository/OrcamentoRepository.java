package com.projects.bem_estar.repository;

import com.projects.bem_estar.models.Mercado;
import com.projects.bem_estar.models.Orcamento;
import com.projects.bem_estar.models.OrcamentoId;
import com.projects.bem_estar.models.PlanoAlimentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, OrcamentoId> {


    @Query("SELECT o FROM Orcamento o WHERE o.status = :status")
    List<Orcamento> findByStatus(@Param("status") String status);

    @Query("SELECT o FROM Orcamento o WHERE o.planoAlimentar.id = :PlanoAlimentar_idPlanoAlimentar")
    List<Orcamento> findByPlanoAlimentarId(@Param("PlanoAlimentar_idPlanoAlimentar")Long planoAlimentarId);

    @Query("SELECT o FROM Orcamento o WHERE o.mercado.id = :idMercado")
    List<Orcamento> findByMercado(@Param("idMercado") Long idMercado);

    @Query("SELECT o FROM Orcamento o WHERE o.mercado.idMercado = :idMercado AND o.planoAlimentar.idPlanoAlimentar = :idPlanoAlimentar")
    Optional<Orcamento> findByPks(@Param("idMercado") Long idMercado, @Param("idPlanoAlimentar") Long idPlanoAlimentar);

}
