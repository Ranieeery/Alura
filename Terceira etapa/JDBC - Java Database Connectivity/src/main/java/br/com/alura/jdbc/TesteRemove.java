package br.com.alura.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;


public class TesteRemove {
  public static void main(String[] args) throws SQLException{
    ConnectionFactory connectionFactory = new ConnectionFactory();
    Connection connection = connectionFactory.recupConnection();

    Statement statement = connection.createStatement();
    statement.execute("DELETE FROM PRODUTO WHERE ID > 2");

    Integer count = statement.getUpdateCount();
    System.out.println("Quantidade de linhas afetadas: " + count);
  }
}
