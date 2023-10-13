package com.projects.bem_estar.models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "frequencia")
public class Frequencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFrequencia;

    private char fequencia;
    private Date tempo;

    public Frequencia() {
        // Construtor vazio necessário para o Hibernate
    }

    public Frequencia(char fequencia, Date tempo) {
        this.fequencia = fequencia;
        this.tempo = tempo;
    }

    public Frequencia(Long idFrequencia, char fequencia, Date tempo) {
        this.idFrequencia = idFrequencia;
        this.fequencia = fequencia;
        this.tempo = tempo;
    }

    public Long getIdFrequencia() {
        return idFrequencia;
    }

    public void setIdFrequencia(Long idFrequencia) {
        this.idFrequencia = idFrequencia;
    }

    public char getFequencia() {
        return fequencia;
    }

    public void setFequencia(char fequencia) {
        this.fequencia = fequencia;
    }

    public Date getTempo() {
        return tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return "Frequencia{" +
                "idFrequencia=" + idFrequencia +
                ", fequencia=" + fequencia +
                ", tempo=" + tempo +
                '}';
    }
}

