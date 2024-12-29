package br.com.alura.Domain;

public class Pet {

    private Tipo tipo;
    private String nome;
    private String raca;
    private int idade;
    private String cor;
    private Float peso;

    public Pet(Tipo tipo, String nome, String raca, int idade, String cor, Float peso) {
        this.tipo = tipo;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.cor = cor;
        this.peso = peso;
    }
}
