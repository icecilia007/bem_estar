package com.projects.bem_estar.repository;

import com.projects.bem_estar.models.Mercado;
import com.projects.bem_estar.models.Nutricionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {
    Nutricionista findByEmail(String email);

    Nutricionista findByInscricao(String inscricao);

    @Query("SELECT n FROM Nutricionista n WHERE n.regiao_crn = :regiao_crn")
    List<Nutricionista> findByRegiao_crn(@Param("regiao_crn") Long regiao_crn);
    @Query(value = "SELECT * FROM nutricionista WHERE email = :email AND senha = :senha", nativeQuery = true)
    Optional<Nutricionista> findByLogin(@Param("email")String email, @Param("senha") String senha);
}