package com.projects.bem_estar.service;

import com.projects.bem_estar.models.AvaliarMercado;

import java.util.List;

public interface AvaliarMercadoService {
     AvaliarMercado getAvaliarMercadoById(Long id);
     List<AvaliarMercado> getAllAvaliarMercado();
     AvaliarMercado createAvaliarMercado(AvaliarMercado AvaliarMercado);
     AvaliarMercado updateAvaliarMercado(Long id, AvaliarMercado AvaliarMercado);
     AvaliarMercado deleteAvaliarMercado(Long id);
}
