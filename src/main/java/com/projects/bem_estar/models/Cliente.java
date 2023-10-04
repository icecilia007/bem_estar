package com.projects.bem_estar.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente", nullable = false)
    private Long idCliente;
    @Column(nullable = false,name= "nome")
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, name= "senha")
    private String senha;
    @Column(name= "num_telefone")
    private String num_telefone;
    @ManyToOne // Relacionamento muitos para um com a tabela "endereco"
    @JoinColumn(name = "endereco_idEndereco",nullable = false)
    private Endereco endereco;
    public Cliente() {
    }

    public Cliente(String name, String email, String cpf, String senha) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Cliente(String name, String email, String cpf, String senha, Endereco endereco) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Cliente(Long idCliente, String name, String email, String cpf, String senha, Endereco endereco) {
        this.idCliente = idCliente;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Long getIdCliente() {
        return idCliente;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + idCliente +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", password='" + senha + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
