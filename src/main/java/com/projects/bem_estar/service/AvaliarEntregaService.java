package com.projects.bem_estar.service;

import com.projects.bem_estar.models.AvaliarEntrega;

import java.util.List;

public interface AvaliarEntregaService {
     AvaliarEntrega getAvaliarEntregaById(Long id);
     List<AvaliarEntrega> getAllAvaliarEntrega();
     AvaliarEntrega createAvaliarEntrega(AvaliarEntrega avaliarEntrega);
     AvaliarEntrega updateAvaliarEntrega(Long id,AvaliarEntrega avaliarEntrega);
     AvaliarEntrega deleteAvaliarEntrega(Long id);
}
