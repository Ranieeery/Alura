package br.com.alura.jdbc.modelo;

public class Produto {

  private Integer id;
  private String nome;
  private String descricao;
  private Integer categoriaId;

  public Produto(String nome, String descricao) {
    this.nome = nome.toUpperCase();
    this.descricao = descricao.toUpperCase();
  }

  public Produto(Integer id, String nome, String descricao) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

  public Integer getCategoriaId() {
    return categoriaId;
  }

  @Override
  public String toString() {
    return "Produto [id: " + id + " | Nome: " + nome + " | Descricao: " + descricao + "]";
  }
}
