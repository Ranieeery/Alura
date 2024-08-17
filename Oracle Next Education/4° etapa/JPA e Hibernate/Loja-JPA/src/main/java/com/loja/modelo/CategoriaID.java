package com.loja.modelo;

import jakarta.persistence.Embeddable;

@Embeddable
public class CategoriaID implements java.io.Serializable{
    private String nome;
    private String tipo;

    public CategoriaID() {
    }

    public CategoriaID(String tipo) {
        this.tipo = tipo;
    }

    public CategoriaID(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
