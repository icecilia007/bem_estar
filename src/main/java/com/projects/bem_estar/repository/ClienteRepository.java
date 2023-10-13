package com.projects.bem_estar.repository;

import com.projects.bem_estar.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.cpf = ?1")
    Optional<Cliente> findByCpf(String cpf);
    @Query(value = "SELECT * FROM cliente WHERE cpf = :cpf AND senha = :senha", nativeQuery = true)
    Optional<Cliente> findByLogin(@Param("cpf") String cpf,@Param("senha")String senha);
}