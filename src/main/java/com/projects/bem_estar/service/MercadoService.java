package com.projects.bem_estar.service;


import com.projects.bem_estar.models.Mercado;

import java.util.List;
import java.util.Optional;

public interface MercadoService {
    List<Mercado> getAllMercados();

    Mercado getMercadoById(Long id);

    Mercado getMercadoByCnpj(String cnpj);

    Mercado createMercado(Mercado mercado);

    Mercado updateMercado(Long id, Mercado mercado);

    Mercado updateMercadoEndereco(Long id, Mercado mercado);

    void deleteMercadoById(Long id);

    Optional<Mercado> getLogin(String identificador, String senha);
}
