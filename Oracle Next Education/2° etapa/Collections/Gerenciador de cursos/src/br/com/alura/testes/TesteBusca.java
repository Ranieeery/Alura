package br.com.alura.testes;

import br.com.alura.Aula;
import br.com.alura.Aluno;
import br.com.alura.Curso;

public class TesteBusca {
  public static void main(String[] args) {
    Curso curso = new Curso("Dominando as coleções do Java", "Paulo Silveira");
    curso.add(new Aula("Trabalhando com ArrayList", 21));
    curso.add(new Aula("Criando uma aula", 20));
    curso.add(new Aula("Modelando com coleções", 24));

    Aluno a1 = new Aluno("Eduardo Santos", 15478);
    Aluno a2 = new Aluno("Maria Silva", 48645);
    Aluno a3 = new Aluno("Pedro Delesporte", 13054);

    curso.matricula(a1);
    curso.matricula(a2);
    curso.matricula(a3);

    Aluno aluno = curso.buscaMatricula(48645);
    System.out.println("Aluno: " + aluno);
  }
}
