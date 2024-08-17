package br.com.alura.testes;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import br.com.alura.Aula;
import br.com.alura.Curso;

public class TesteCurso {
  public static void main(String[] args) {
    Curso curso = new Curso("Dominando as coleções do Java", "Paulo Silveira");
    curso.add(new Aula("Trabalhando com ArrayList", 21));
    curso.add(new Aula("Criando uma aula", 20));
    curso.add(new Aula("Modelando com coleções", 24));

    List<Aula> aulasImutaveis = curso.getAulas();
    System.out.println(aulasImutaveis);

    List<Aula> aulas = new ArrayList<>(aulasImutaveis);
    
    Collections.sort(aulas);
    System.out.println(aulas);
    System.out.println(curso.getTempoTotal());

    System.out.println(curso);
  }
}
