package com.projects.bem_estar.service;

import com.projects.bem_estar.models.AvaliarMercado;

import java.util.List;

public interface AvaliarMercadoService {
     AvaliarMercado getAvaliarEntregaById(Long id);
     List<AvaliarMercado> getAllAvaliarEntrega();
     AvaliarMercado createAvaliarEntrega(AvaliarMercado avaliarEntrega);
     AvaliarMercado updateAvaliarEntrega(Long id, AvaliarMercado avaliarEntrega);
     AvaliarMercado deleteAvaliarEntrega(Long id);
}
