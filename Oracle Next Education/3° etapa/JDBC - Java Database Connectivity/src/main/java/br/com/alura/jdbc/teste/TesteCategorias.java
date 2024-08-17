package br.com.alura.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.jdbc.modelo.CategoriaDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TesteCategorias {
  public static void main(String[] args) throws SQLException {
    try (Connection connection = new ConnectionFactory().recupConnection()) {
      CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
      List<Categoria> listaCategoria = categoriaDAO.listProdutos();
      listaCategoria.stream().forEach(lista -> {
        System.out.println(lista.getNome());
        for (Produto produto : lista.getProdutos()) {
          System.out.println("Categoria: " + lista.getNome() + " | Produto: " + produto.getNome());
        }
      });
    }
  }
}
