package com.projects.bem_estar.helpers;

public class Login {
    private String identificador;
    private String senha;

    public Login() {
    }

    public Login(String identificador, String senha) {
        this.identificador = identificador;
        this.senha = senha;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login{" +
                "identificador='" + identificador + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
