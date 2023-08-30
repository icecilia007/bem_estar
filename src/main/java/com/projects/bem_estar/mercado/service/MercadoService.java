package com.projects.bem_estar.mercado.service;


import com.projects.bem_estar.mercado.model.Mercado;

import java.util.List;

public interface MercadoService {
    List<Mercado> getAllMercados();
    Mercado getMercadoById(Long id);
    Mercado getMercadoByCnpj(String cnpj);
    Mercado createMercado(Mercado mercado);
    Mercado updateMercado(Long id, Mercado mercado);
    void deleteMercadoById(Long id);
}
