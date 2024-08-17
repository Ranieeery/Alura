package br.com.alura.testes;

// import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collection;

public class TesteAlunos {
  public static void main(String[] args) {

    // Set<String> alunos = new HashSet<>();
    Collection<String> alunos = new HashSet<>();
    alunos.add("Rodrigo Turini");
    alunos.add("Alberto Souza");
    alunos.add("Nico Steppat");
    alunos.add("Sergio Lopes");
    alunos.add("Renan Saggio");
    alunos.add("Mauricio de Sousa");

    System.out.println(alunos.size());

    System.out.println("--------------------");

    for (String aluno : alunos) {
      System.out.println(aluno);
    }

    System.out.println("--------------------");
    
    alunos.forEach(aluno -> {
      System.out.println(aluno);
    });
    
    System.out.println("--------------------");

    boolean alunoMatriculado = alunos.contains("Paulo Silveira");
    System.out.println(alunoMatriculado);
    
    System.out.println("--------------------");

    List<String> alunosEmLista = new ArrayList<>(alunos);
    System.out.println(alunosEmLista);
  }
}