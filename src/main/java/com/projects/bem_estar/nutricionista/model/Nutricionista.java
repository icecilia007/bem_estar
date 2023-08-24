package com.projects.bem_estar.nutricionista.model;

import jakarta.persistence.*;

@Entity
public class Nutricionista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String inscricao;
    @Column(nullable = false)
    private Long regiao_crn;

    @Column(nullable = false)
    private String password;

    public Nutricionista() {
    }

    public Nutricionista(Long id, String name, String email, String inscricao, Long regiao_crn, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.inscricao = inscricao;
        this.regiao_crn = regiao_crn;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getRegiao_crn() {
        return regiao_crn;
    }

    public void setRegiao_crn(Long regiao_crn) {
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", inscricao='" + inscricao + '\'' +
                ", regiao_crn=" + regiao_crn +
                ", password='" + password + '\'' +
                '}';
    }
}
