package com.loja.modelo;


import jakarta.persistence.Entity;

@Entity
public class Livro extends Produto{
    private String isbn;
    private String autor;
    private String editora;
    private String numeroPaginas;

    public Livro() {
    }

    public Livro(String isbn, String autor, String editora, String numeroPaginas) {
        this.isbn = isbn;
        this.autor = autor;
        this.editora = editora;
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
