package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
public class TestaConexao {
  public static void main(String[] args) {
    
    ConnectionFactory connectionFactory = new ConnectionFactory();

    try (Connection connection = connectionFactory.recupConnection()) {
      System.out.println("Conexão aberta!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
