package br.com.alura.jdbc.modelo;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CategoriaDAO {
  private Connection connection;

  public CategoriaDAO(Connection connection) {
    this.connection = connection;
  }

  public List<Categoria> list() throws SQLException {
    List<Categoria> categorias = new ArrayList<>();

    try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, NOME FROM CATEGORIA")) {
      preparedStatement.execute();

      try (ResultSet resultSet = preparedStatement.getResultSet()) {
        while (resultSet.next()) {
          Categoria categoria = new Categoria(resultSet.getInt(1), resultSet.getString(2));
          categorias.add(categoria);
        }
      }
    }
    return categorias;
  }

  public List<Categoria> listProdutos() throws SQLException {
    Categoria last = null;
    List<Categoria> categorias = new ArrayList<>();

    try (PreparedStatement preparedStatement = connection
        .prepareStatement(
            "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN PRODUTO P ON C.ID = P.CATEGORIA_ID")) {
      preparedStatement.execute();

      try (ResultSet resultSet = preparedStatement.getResultSet()) {
        while (resultSet.next()) {
          if (last == null || !last.getNome().equals(resultSet.getString(2))) {
            Categoria categoria = new Categoria(resultSet.getInt(1), resultSet.getString(2));
            last = categoria;
            categorias.add(categoria);
          }
          Produto produto = new Produto(resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
          last.add(produto);
        }
      }
    }
    return categorias;
  }
}
