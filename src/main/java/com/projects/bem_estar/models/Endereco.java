package com.projects.bem_estar.models;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco") // Mapeamento para a tabela "endereco" no banco de dados
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEndereco")
    private Long idEndereco;

    @Column(name = "cep")
    private String cep;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "vizinha")
    private String vizinha;

    @Column(name = "rua")
    private String rua;

    @Column(name = "servico")
    private String servico;

    @Column(name = "numero")
    private Double numero;

    public Endereco() {
    }

    public Endereco(Long idEndereco, String cep, String estado, String cidade, String vizinha, String rua, String servico, Double numero) {
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.vizinha = vizinha;
        this.rua = rua;
        this.servico = servico;
        this.numero = numero;
    }

    public Endereco(String cep, String estado, String cidade, String vizinha, String rua, String servico, Double numero) {
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.vizinha = vizinha;
        this.rua = rua;
        this.servico = servico;
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getVizinha() {
        return vizinha;
    }

    public void setVizinha(String vizinha) {
        this.vizinha = vizinha;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Double getNumero() {
        return numero;
    }

    public void setNumero(Double numero) {
        this.numero = numero;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", uf='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + vizinha + '\'' +
                ", endereco='" + rua + '\'' +
                ", complemento='" + servico + '\'' +
                ", numero=" + numero +
                '}';
    }
}
