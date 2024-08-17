package br.com.alura.jdbc.modelo;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ProdutoDAO {
  private Connection connection;

  public ProdutoDAO(Connection connection) {
    this.connection = connection;
  }

  public void saveProduto(Produto produto) throws SQLException {
    String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)";

    try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      preparedStatement.setString(1, produto.getNome());
      preparedStatement.setString(2, produto.getDescricao());

      preparedStatement.execute();

      try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
        while (resultSet.next()) {
          produto.setId(resultSet.getInt(1));
        }
      }
    }
  }

  public List<Produto> listProdutos() throws SQLException {
    List<Produto> produtos = new ArrayList<>();

    try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUTO")) {
      preparedStatement.execute();

      try (ResultSet resultSet = preparedStatement.getResultSet()) {
        while (resultSet.next()) {
          Produto produto = new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
          produtos.add(produto);
        }
      }
    }
    return produtos;
  }

  public List<Produto> listCategoria(Categoria lista) throws SQLException {
    List<Produto> produtos = new ArrayList<>();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement("SELECT * FROM PRODUTO WHERE CATEGORIA_ID = ?")) {
      preparedStatement.setInt(1, lista.getId());
      preparedStatement.execute();

      try (ResultSet resultSet = preparedStatement.getResultSet()) {
        while (resultSet.next()) {
          Produto produto = new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
          produtos.add(produto);
        }
      }
    }
    return produtos;
  }
}
