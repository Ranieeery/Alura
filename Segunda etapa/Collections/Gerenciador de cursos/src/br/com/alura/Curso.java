package br.com.alura;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Curso {
  private String nome;
  private String instrutor;
  private List<Aula> aulas = new ArrayList<Aula>();
  private Set<Aluno> alunos = new HashSet<Aluno>();
  private Map<Integer, Aluno> matriculaAluno = new HashMap<>();

  public Curso(String nome, String instrutor) {
    this.nome = nome;
    this.instrutor = instrutor;
  }

  public String getNome() {
    return nome;
  }

  public String getInstrutor() {
    return instrutor;
  }

  public List<Aula> getAulas() {
    return Collections.unmodifiableList(aulas);
  }

  public void add(Aula aula) {
    this.aulas.add(aula);
  }

  public String getTempoTotal() {
    return this.aulas.stream().mapToInt(Aula::getTempo).sum() + " minutos";
  }

  @Override
  public String toString() { 
    return """
     ======================================= 
      Curso: %s
      Instrutor: %s
      Tempo total: %s
        """.formatted(this.nome, this.instrutor, this.getTempoTotal());
  }

  public void matricula(Aluno aluno) {
    this.alunos.add(aluno);
    this.matriculaAluno.put(aluno.getNumeroMatricula(), aluno);
  }

  public Set<Aluno> getAlunos() {
    return Collections.unmodifiableSet(alunos);
  }

  public String isMatriculado(Aluno aluno) {
    return this.alunos.contains(aluno) ? "Aluno matriculado" : "Aluno não matriculado";
  }

  public Aluno buscaMatricula(int numero) {

    if (!matriculaAluno.containsKey(numero)) {
      throw new NoSuchElementException("Aluno não encontrado");
    }

    return matriculaAluno.get(numero);
  }
  //   for (Aluno aluno : alunos) {
  //     if (aluno.getNumeroMatricula() == numero) return aluno;
  //   }
  //   throw new NoSuchElementException("Aluno não encontrado");    
  // }
}
