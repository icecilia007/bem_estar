package com.projects.bem_estar.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {
    @Id
    @Column(name = "idIngrediente")
    private Long idIngrediente;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "porcao")
    private int porcao;

    @Column(name = "caloria")
    private Double caloria;


    public Ingrediente() {
    }

    public Ingrediente(String nome, int porcao, Double caloria) {
        this.nome = nome;
        this.porcao = porcao;
        this.caloria = caloria;
    }

    public Ingrediente(Long idIngrediente, String nome, int porcao, Double caloria) {
        this.idIngrediente = idIngrediente;
        this.nome = nome;
        this.porcao = porcao;
        this.caloria = caloria;
    }

    public Long getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPorcao() {
        return porcao;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
    }

    public Double getCaloria() {
        return caloria;
    }

    public void setCaloria(Double caloria) {
        this.caloria = caloria;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "idIngrediente=" + idIngrediente +
                ", nome='" + nome + '\'' +
                ", porcao=" + porcao +
                ", caloria=" + caloria +
                '}';
    }
}

