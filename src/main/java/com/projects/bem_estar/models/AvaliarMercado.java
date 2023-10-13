package com.projects.bem_estar.models;
import jakarta.persistence.*;
@Entity
@Table(name = "avaliarmercado")
public class AvaliarMercado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAvaliacao")
    private Long idAvaliarEntrega;

    private int atendimento;
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "cliente_idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "mercado_idMercado")
    private Mercado mercado;

    public AvaliarMercado(int atendimento, String comentarios, Cliente cliente, Mercado mercado) {
        this.atendimento = atendimento;
        this.comentarios = comentarios;
        this.cliente = cliente;
        this.mercado = mercado;
    }

    public AvaliarMercado() {
    }

    public AvaliarMercado(Long idAvaliarEntrega, int atendimento, String comentarios, Cliente cliente, Mercado mercado) {
        this.idAvaliarEntrega = idAvaliarEntrega;
        this.atendimento = atendimento;
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
}
