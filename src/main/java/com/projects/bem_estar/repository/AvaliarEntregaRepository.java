package com.projects.bem_estar.repository;

import com.projects.bem_estar.models.AvaliarEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliarEntregaRepository extends JpaRepository<AvaliarEntrega, Long> {
}
