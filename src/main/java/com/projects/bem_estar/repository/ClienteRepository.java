package com.projects.bem_estar.repository;

import com.projects.bem_estar.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.cpf = ?1")
    Optional<Cliente> findByCpf(String cpf);
}