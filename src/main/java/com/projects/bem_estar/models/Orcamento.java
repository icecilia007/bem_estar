package com.projects.bem_estar.models;
import jakarta.persistence.*;

@Entity
@Table(name = "orcamento")
public class Orcamento {
    @Id
    @ManyToOne
    @JoinColumn(name = "mercado_idMercado", nullable = false)
    private Mercado mercado;

    @Id
    @ManyToOne
    @JoinColumn(name = "PlanoAlimentar_idPlanoAlimentar", nullable = false)
    private PlanoAlimentar planoAlimentar;

    private Double valor;

    private String status;

    public Orcamento() {
    }

    public Orcamento(Mercado mercado, PlanoAlimentar planoAlimentar, Double valor) {
        this.mercado = mercado;
        this.planoAlimentar = planoAlimentar;
        this.valor = valor;
    }

    public Orcamento(Mercado mercado, PlanoAlimentar planoAlimentar, Double valor, String status) {
        this.mercado = mercado;
        this.planoAlimentar = planoAlimentar;
        this.valor = valor;
        this.status = status;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }

    public PlanoAlimentar getPlanoAlimentar() {
        return planoAlimentar;
    }

    public void setPlanoAlimentar(PlanoAlimentar planoAlimentar) {
        this.planoAlimentar = planoAlimentar;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Orcamento{" +
                "mercado=" + mercado +
                ", planoAlimentar=" + planoAlimentar +
                ", valor=" + valor +
                ", status='" + status + '\'' +
                '}';
    }
}
