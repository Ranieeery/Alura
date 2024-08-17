package com.loja.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @EmbeddedId
    public CategoriaID id;
    public Categoria() {
    }
    public Categoria(String tipo) {
        this.id = new CategoriaID(tipo);
    }

    public Categoria(String nome, String tipo) {
        this.id = new CategoriaID(nome, tipo);
    }
    public CategoriaID getId() {
        return id;
    }

    public String getNome() {
        return id.getNome();
    }

    public void setNome(String nome) {
        this.id = new CategoriaID(nome, id.getTipo());
    }
}
