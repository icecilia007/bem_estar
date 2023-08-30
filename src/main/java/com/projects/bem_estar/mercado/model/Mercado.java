package com.projects.bem_estar.mercado.model;

import com.projects.bem_estar.endereco.model.Endereco;
import jakarta.persistence.*;

@Entity
@Table(name = "mercado")
public class Mercado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Column
    private String num_telefone;

    @Column(nullable = false)
    private String password;

    public Mercado() {
    }

    public Mercado(String name, String cnpj, String email, Endereco endereco, String num_telefone, String password) {
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.endereco = endereco;
        this.num_telefone = num_telefone;
        this.password = password;
    }

    public Mercado(Long id, String name, String cnpj, String email, Endereco endereco, String num_telefone, String password) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.endereco = endereco;
        this.num_telefone = num_telefone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Mercado{" +
                "name='" + name + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                ", num_telefone='" + num_telefone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
