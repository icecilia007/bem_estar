package com.projects.bem_estar.models;

import jakarta.persistence.*;

@Entity
public class Nutricionista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNutricionista;
    @Column(nullable = false, name="nome")
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String inscricao;
    @Column(nullable = false)
    private String regiao_crn;

    @Column(nullable = false, name="senha")
    private String password;
    @Column(nullable = true, name="num_telefone")
    private String num_telefone;

    public Nutricionista() {
    }

    public Nutricionista(Long idNutricionista, String name, String email, String inscricao, String regiao_crn, String password) {
        this.idNutricionista = idNutricionista;
        this.name = name;
        this.email = email;
        this.inscricao = inscricao;
        this.regiao_crn = regiao_crn;
        this.password = password;
    }

    public Long getIdNutricionista() {
        return idNutricionista;
    }

    public void setIdNutricionista(Long idNutricionista) {
        this.idNutricionista = idNutricionista;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getRegiao_crn() {
        return regiao_crn;
    }

    public void setRegiao_crn(String regiao_crn) {
        this.regiao_crn = regiao_crn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Nutricionista{" +
                "id=" + idNutricionista +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", inscricao='" + inscricao + '\'' +
                ", regiao_crn=" + regiao_crn +
                ", password='" + password + '\'' +
                '}';
    }
}
