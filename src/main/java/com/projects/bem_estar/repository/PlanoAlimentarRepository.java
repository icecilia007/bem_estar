package com.projects.bem_estar.repository;

import com.projects.bem_estar.models.PlanoAlimentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlanoAlimentarRepository extends JpaRepository<PlanoAlimentar, Long> {
    @Query("SELECT p FROM PlanoAlimentar p WHERE p.cliente.idCliente = :clienteId")
    List<PlanoAlimentar> findByClienteId(@Param("clienteId") Long clienteId);
    @Query("SELECT p FROM PlanoAlimentar p WHERE p.nutricionista.idNutricionista = :nutricionistaId")
    List<PlanoAlimentar> findByNutricionistaId(@Param("nutricionistaId")Long nutricionistaId);
    @Query("SELECT p FROM PlanoAlimentar p WHERE p.mercado.idMercado = :mercadoId")
    List<PlanoAlimentar> findByMercadoId(@Param("mercadoId") Long mercadoId);
    @Query("SELECT p FROM PlanoAlimentar p WHERE p.status = :status")
    List<PlanoAlimentar> findByStatus(@Param("status") String status);
}
