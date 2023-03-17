package br.com.alura.jdbc.modelo;

public class Produto {

  private Integer id;
  private String nome;
  private String descricao;

  public Produto(String nome, String descricao) {
    this.nome = nome.toUpperCase();
    this.descricao = descricao.toLowerCase();
  }

  public Integer getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Produto [id: " + id + " | Nome: " + nome + " | Descricao: " + descricao + "]";
  }
}
