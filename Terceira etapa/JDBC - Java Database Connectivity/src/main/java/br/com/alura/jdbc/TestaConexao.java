package br.com.alura.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class TestaConexao {
  public static void main(String[] args) {
    
    Dotenv dotenv = Dotenv.load();
    String dbUser = dotenv.get("USER");
    String dbPassword = dotenv.get("PASSWORD");

    try (Connection connection = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/loja_virtual", dbUser, dbPassword)) {
      System.out.println("Conexão aberta!");

      Statement statement = connection.createStatement();
      statement.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
      ResultSet resultSet = statement.getResultSet();

      while (resultSet.next()) {
        Integer id = resultSet.getInt("ID");
        String nome = resultSet.getString("NOME");
        String descricao = resultSet.getString("DESCRICAO");
        System.out.println(id + " - " + nome + " - " + descricao);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
