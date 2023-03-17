package br.com.alura.jdbc.teste;

import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;

public class TestePool {
  public static void main(String[] args) throws SQLException {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    for (int i = 0; i < 20; i++) {
      connectionFactory.recupConnection();
      System.out.println("Conexão de número: " + (i+1));
    }
  }
}
