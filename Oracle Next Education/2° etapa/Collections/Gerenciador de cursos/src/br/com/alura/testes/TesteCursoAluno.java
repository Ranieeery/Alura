package br.com.alura.testes;

import java.util.Set;
import java.util.Iterator;

import br.com.alura.Aluno;
import br.com.alura.Aula;
import br.com.alura.Curso;

public class TesteCursoAluno {
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

    System.out.println("Todos os alunos matriculados:");
    curso.getAlunos().forEach(aluno -> {
      System.out.println(aluno);
    });

    System.out.println(curso.isMatriculado(a1));

    Aluno a4 = new Aluno("Eduardo Santos", 15478);
    System.out.println(curso.isMatriculado(a4));

    System.out.println(a1.equals(a4));

    System.out.println(a1.hashCode() == a4.hashCode());

    Set<Aluno> alunos = curso.getAlunos();
    Iterator<Aluno> iterator = alunos.iterator();

    while (iterator.hasNext()) {
      Aluno proximo = iterator.next();
      System.out.println(proximo);
    }
    
  }
}
