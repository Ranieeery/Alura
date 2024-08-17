package br.com.alura;

public class Aula implements Comparable<Aula> { // Comparable é uma interface que permite comparar objetos e é
                                                // necessário implementar o método compareTo()
  private String titulo;
  private int tempo;

  public Aula(String titulo, int tempo) {
    this.titulo = titulo;
    this.tempo = tempo;
  }

  public String getTitulo() {
    return titulo;
  }

  public int getTempo() {
    return tempo;
  }

  @Override
  public String toString() {
    return "[Aula: " + this.titulo + ", " + this.tempo + " minutos]";
  }

  @Override
  public int compareTo(Aula o) {
    return this.titulo.compareTo(o.titulo);
  }

}
