package com.projects.bem_estar.models;
import jakarta.persistence.*;
@Entity
@Table(name = "AvaliarEntrega")
public class AvaliarEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAvaliarEntrega")
    private Long idAvaliarEntrega;

    private int atendimento;
    private int tempoDeEntrega;
    private int qualidadeDeEntrega;
    private int qualidadeDoProduto;
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "cliente_idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "mercado_idMercado")
    private Mercado mercado;

    public AvaliarEntrega() {
    }

    public AvaliarEntrega(int atendimento, int tempoDeEntrega, int qualidadeDeEntrega, int qualidadeDoProduto, String comentarios) {
        this.atendimento = atendimento;
        this.tempoDeEntrega = tempoDeEntrega;
        this.qualidadeDeEntrega = qualidadeDeEntrega;
        this.qualidadeDoProduto = qualidadeDoProduto;
        this.comentarios = comentarios;
    }

    public AvaliarEntrega(int atendimento, int tempoDeEntrega, int qualidadeDeEntrega, int qualidadeDoProduto, String comentarios, Cliente cliente, Mercado mercado) {
        this.atendimento = atendimento;
        this.tempoDeEntrega = tempoDeEntrega;
        this.qualidadeDeEntrega = qualidadeDeEntrega;
        this.qualidadeDoProduto = qualidadeDoProduto;
        this.comentarios = comentarios;
        this.cliente = cliente;
        this.mercado = mercado;
    }

    public AvaliarEntrega(Long idAvaliarEntrega, int atendimento, int tempoDeEntrega, int qualidadeDeEntrega, int qualidadeDoProduto, String comentarios, Cliente cliente, Mercado mercado) {
        this.idAvaliarEntrega = idAvaliarEntrega;
        this.atendimento = atendimento;
        this.tempoDeEntrega = tempoDeEntrega;
        this.qualidadeDeEntrega = qualidadeDeEntrega;
        this.qualidadeDoProduto = qualidadeDoProduto;
        this.comentarios = comentarios;
        this.cliente = cliente;
        this.mercado = mercado;
    }

    public Long getIdAvaliarEntrega() {
        return idAvaliarEntrega;
    }

    public void setIdAvaliarEntrega(Long idAvaliarEntrega) {
        this.idAvaliarEntrega = idAvaliarEntrega;
    }

    public int getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(int atendimento) {
        this.atendimento = atendimento;
    }

    public int getTempoDeEntrega() {
        return tempoDeEntrega;
    }

    public void setTempoDeEntrega(int tempoDeEntrega) {
        this.tempoDeEntrega = tempoDeEntrega;
    }

    public int getQualidadeDeEntrega() {
        return qualidadeDeEntrega;
    }

    public void setQualidadeDeEntrega(int qualidadeDeEntrega) {
        this.qualidadeDeEntrega = qualidadeDeEntrega;
    }

    public int getQualidadeDoProduto() {
        return qualidadeDoProduto;
    }

    public void setQualidadeDoProduto(int qualidadeDoProduto) {
        this.qualidadeDoProduto = qualidadeDoProduto;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }

    @Override
    public String toString() {
        return "AvaliarEntrega{" +
                "idAvaliarEntrega=" + idAvaliarEntrega +
                ", atendimento=" + atendimento +
                ", tempoDeEntrega=" + tempoDeEntrega +
                ", qualidadeDeEntrega=" + qualidadeDeEntrega +
                ", qualidadeDoProduto=" + qualidadeDoProduto +
                ", comentarios='" + comentarios + '\'' +
                ", cliente=" + cliente +
                ", mercado=" + mercado +
                '}';
    }
}
