package com.projects.bem_estar.endereco.model;

import jakarta.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="cep")
    private String cep;
    @Column(name ="tipo_cep")
    private String tipoCep;
    @Column(name ="sub_tipo_cep")
    private String subTipoCep;
    @Column(name ="uf")
    private String uf;
    @Column(name ="cidade")
    private String cidade;
    @Column(name ="bairro")
    private String bairro;
    @Column(name ="endereco")
    private String endereco;
    @Column(name ="complemento")
    private String complemento;
    @Column(name ="codigo_ibge")
    private String codigoIBGE;

    public Endereco() {
    }

    public Endereco(Long id, String cep, String tipoCep, String subTipoCep, String uf, String cidade, String bairro, String endereco, String complemento, String codigoIBGE) {
        this.id = id;
        this.cep = cep;
        this.tipoCep = tipoCep;
        this.subTipoCep = subTipoCep;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.complemento = complemento;
        this.codigoIBGE = codigoIBGE;
    }

    public Endereco(String cep, String tipoCep, String subTipoCep, String uf, String cidade, String bairro, String endereco, String complemento, String codigoIBGE) {
        this.cep = cep;
        this.tipoCep = tipoCep;
        this.subTipoCep = subTipoCep;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.complemento = complemento;
        this.codigoIBGE = codigoIBGE;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipoCep() {
        return tipoCep;
    }

    public void setTipoCep(String tipoCep) {
        this.tipoCep = tipoCep;
    }

    public String getSubTipoCep() {
        return subTipoCep;
    }

    public void setSubTipoCep(String subTipoCep) {
        this.subTipoCep = subTipoCep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    public void setCodigoIBGE(String codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", tipoCep='" + tipoCep + '\'' +
                ", subTipoCep='" + subTipoCep + '\'' +
                ", uf='" + uf + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", codigoIBGE='" + codigoIBGE + '\'' +
                '}';
    }
    }
