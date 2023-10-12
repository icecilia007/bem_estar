package com.projects.bem_estar.repository;

import com.projects.bem_estar.models.AvaliarMercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliarMercadoRepository extends JpaRepository<AvaliarMercado, Long> {
}
