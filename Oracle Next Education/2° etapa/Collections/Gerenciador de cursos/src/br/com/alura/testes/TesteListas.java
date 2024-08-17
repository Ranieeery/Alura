package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collections;

public class TesteListas {
    public static void main(String[] args) {
      String aula1 = "Conhecendo mais de listas";
      String aula2 = "Modelando a classe Aula";
      String aula3 = "Trabalhando com Cursos e Sets";

      ArrayList<String> aulas = new ArrayList<>();
      aulas.add(aula1);
      aulas.add(aula2);
      aulas.add(aula3);
      
      System.out.println(aulas);

      aulas.remove(0);
      System.out.println(aulas);

      for (String aula : aulas) {
        System.out.println("Aula: " + aula);
      }

      String primeiraAula = aulas.get(0);
      System.out.println("A primeira aula é " + primeiraAula);

      for (int i = 0; i < aulas.size(); i++) { // Collections usa o método size() ao invés de length()
        System.out.println("Aula: " + aulas.get(i));
      }

      aulas.forEach(aula -> {
        System.out.println("Percorrendo: " + aula);
      });

      aulas.add("Estudando sobre listas");
      System.out.println(aulas);
      Collections.sort(aulas);
      System.out.println("Depois de ordenar: ");
      System.out.println(aulas);

    }
}