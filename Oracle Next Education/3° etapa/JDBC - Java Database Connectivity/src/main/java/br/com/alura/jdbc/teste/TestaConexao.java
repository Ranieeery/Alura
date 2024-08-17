package br.com.alura.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;

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
