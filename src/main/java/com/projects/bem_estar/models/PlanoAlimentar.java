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

    private Date data_entrega;
    private String status;

    @ManyToOne
    @JoinColumn(name = "nutricionista_idNutricionista", nullable = false)
    private Nutricionista nutricionista;

    @ManyToOne
    @JoinColumn(name = "cliente_idCliente", nullable = false)
    private Cliente cliente;

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

    public PlanoAlimentar(Date data_entrega, String status, Nutricionista nutricionista, Cliente cliente, Frequencia frequencia, List<Ingrediente> ingredientes) {
        this.data_entrega = data_entrega;
        this.status = status;
        this.nutricionista = nutricionista;
        this.cliente = cliente;
        this.frequencia = frequencia;
        this.ingredientes = ingredientes;
    }

    public Long getIdPlanoAlimentar() {
        return idPlanoAlimentar;
    }

    public void setIdPlanoAlimentar(Long idPlanoAlimentar) {
        this.idPlanoAlimentar = idPlanoAlimentar;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public boolean adicionarIngrediente(Ingrediente ingrediente){
        return ingredientes.add(ingrediente);
    }
    public boolean removerIngrediente(Ingrediente ingrediente){
        return ingredientes.remove(ingrediente);
    }

    @Override
    public String toString() {
        return "PlanoAlimentar{" +
                "idPlanoAlimentar=" + idPlanoAlimentar +
                ", data_entrega=" + data_entrega +
                ", status='" + status + '\'' +
                ", nutricionista=" + nutricionista +
                ", cliente=" + cliente +
                ", frequencia=" + frequencia +
                ", ingredientes=" + ingredientes +
                '}';
    }
}

