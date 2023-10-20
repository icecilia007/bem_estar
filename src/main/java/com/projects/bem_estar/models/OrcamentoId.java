package com.projects.bem_estar.models;

import java.io.Serializable;
import java.util.Objects;

public class OrcamentoId implements Serializable {
    private Long mercado;
    private Long planoAlimentar;

    public OrcamentoId() {
    }

    public OrcamentoId(Long mercado, Long planoAlimentar) {
        this.mercado = mercado;
        this.planoAlimentar = planoAlimentar;
    }

    public Long getMercado() {
        return mercado;
    }

    public void setMercado(Long mercado) {
        this.mercado = mercado;
    }

    public Long getPlanoAlimentar() {
        return planoAlimentar;
    }

    public void setPlanoAlimentar(Long planoAlimentar) {
        this.planoAlimentar = planoAlimentar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrcamentoId that = (OrcamentoId) o;
        return Objects.equals(mercado, that.mercado) &&
                Objects.equals(planoAlimentar, that.planoAlimentar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mercado, planoAlimentar);
    }
}

