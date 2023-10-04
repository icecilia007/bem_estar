package com.projects.bem_estar.helpers;

public class Option {
    private String nome;
    private String crn;
    private String registro;
    private boolean geral;

    public Option() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public boolean isGeral() {
        return geral;
    }

    public void setGeral(boolean geral) {
        this.geral = geral;
    }

    @Override
    public String toString() {
        return "{" +
                "\"nome\": \"" + nome + "\"," +
                "\"crn\": \"" + crn + "\"," +
                "\"registro\": \"" + registro + "\"," +
                "\"geral\": " + geral +
                "}";
    }
}