package br.com.alura.testes;

import br.com.alura.Aula;
import br.com.alura.Curso;

public class TesteCurso {
  public static void main(String[] args) {
    Curso curso = new Curso("Dominando as coleções do Java", "Paulo Silveira");
    curso.add(new Aula("Trabalhando com ArrayList", 21));
    curso.add(new Aula("Criando uma aula", 20));
    curso.add(new Aula("Modelando com coleções", 24));
    System.out.println(curso.getAulas());
  }
}
