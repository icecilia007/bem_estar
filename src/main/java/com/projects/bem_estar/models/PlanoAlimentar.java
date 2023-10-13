package com.projects.bem_estar.models;



import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "planoalimentar")
public class PlanoAlimentar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPlanoAlimentar")
    private Long idPlanoAlimentar;

    private Double valorAtual;
    private Date data_entrega;
    private Double valorEsperado;
    private String status;

    @ManyToOne
    @JoinColumn(name = "nutricionista_idNutricionista", nullable = false)
    private Nutricionista nutricionista;

    @ManyToOne
    @JoinColumn(name = "cliente_idCliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "mercado_idMercado")
    private Mercado mercado;

    @ManyToOne
    @JoinColumn(name = "frequencia_idFrequencia")
    private Frequencia frequencia;
    @ManyToMany
    @JoinTable(
            name = "PlanoAlimentarIngrediente",
            joinColumns = @JoinColumn(name = "PlanoAlimentar_idPlanoAlimentar"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_idIngredientes")
    )
    private List<Ingrediente> ingredientes;
    public PlanoAlimentar() {
    }

    public PlanoAlimentar(Double valorAtual, Date data_entrega, Nutricionista nutricionista, Cliente cliente, Mercado mercado, Frequencia frequencia, Double valorEsperado, String status) {
        this.valorAtual = valorAtual;
        this.data_entrega = data_entrega;
        this.nutricionista = nutricionista;
        this.cliente = cliente;
        this.mercado = mercado;
        this.frequencia = frequencia;
        this.valorEsperado = valorEsperado;
        this.status = status;
        this.ingredientes = new ArrayList<>();
    }

    public PlanoAlimentar(Long idPlanoAlimentar, Double valorAtual, Date data_entrega, Double valorEsperado, String status, Nutricionista nutricionista, Cliente cliente, Mercado mercado, Frequencia frequencia, List<Ingrediente> ingredientes) {
        this.idPlanoAlimentar = idPlanoAlimentar;
        this.valorAtual = valorAtual;
        this.data_entrega = data_entrega;
        this.valorEsperado = valorEsperado;
        this.status = status;
        this.nutricionista = nutricionista;
        this.cliente = cliente;
        this.mercado = mercado;
        this.frequencia = frequencia;
        this.ingredientes = ingredientes;
    }

    public boolean adicionarIngrediente(Ingrediente ingrediente){
        return ingredientes.add(ingrediente);
    }
    public boolean removerIngrediente(Ingrediente ingrediente){
        return ingredientes.remove(ingrediente);
    }
    public Long getIdPlanoAlimentar() {
        return idPlanoAlimentar;
    }

    public void setIdPlanoAlimentar(Long idPlanoAlimentar) {
        this.idPlanoAlimentar = idPlanoAlimentar;
    }

    public Double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    public Nutricionista getNutricionista() {
        return nutricionista;
    }

    public void setNutricionista(Nutricionista nutricionista) {
        this.nutricionista = nutricionista;
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

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }

    public Double getValorEsperado() {
        return valorEsperado;
    }

    public void setValorEsperado(Double valorEsperado) {
        this.valorEsperado = valorEsperado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "PlanoAlimentar{" +
                "idPlanoAlimentar=" + idPlanoAlimentar +
                ", valorAtual=" + valorAtual +
                ", data_entrega=" + data_entrega +
                ", nutricionista=" + nutricionista +
                ", cliente=" + cliente +
                ", mercado=" + mercado +
                ", frequencia=" + frequencia +
                ", valorEsperado=" + valorEsperado +
                ", status='" + status + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}

