package com.projects.bem_estar.models;

import com.projects.bem_estar.models.Endereco;
import jakarta.persistence.*;

@Entity
@Table(name = "mercado")
public class Mercado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMercado", nullable = false)
    private Long idMercado;

    @Column(nullable = false, name="nome")
    private String name;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "endereco_idEndereco", nullable = false)
    private Endereco endereco;

    @Column
    private String num_telefone;

    @Column(nullable = false, name="senha")
    private String senha;

    public Mercado() {
    }

    public Mercado(String name, String cnpj, String email, Endereco endereco, String num_telefone, String senha) {
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.endereco = endereco;
        this.num_telefone = num_telefone;
        this.senha = senha;
    }

    public Mercado(Long idMercado, String name, String cnpj, String email, Endereco endereco, String num_telefone, String senha) {
        this.idMercado = idMercado;
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.endereco = endereco;
        this.num_telefone = num_telefone;
        this.senha = senha;
    }

    public Long getIdMercado() {
        return idMercado;
    }

    public void setIdMercado(Long idMercado) {
        this.idMercado = idMercado;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNum_telefone() {
        return num_telefone;
    }

    public void setNum_telefone(String num_telefone) {
        this.num_telefone = num_telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Mercado{" +
                "name='" + name + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                ", num_telefone='" + num_telefone + '\'' +
                ", password='" + senha + '\'' +
                '}';
    }
}
