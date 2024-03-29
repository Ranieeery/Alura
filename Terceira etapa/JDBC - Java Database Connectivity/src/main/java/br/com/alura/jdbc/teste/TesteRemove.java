package br.com.alura.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.jdbc.ConnectionFactory;


public class TesteRemove {
  public static void main(String[] args) throws SQLException{
    ConnectionFactory connectionFactory = new ConnectionFactory();
    Connection connection = connectionFactory.recupConnection();

    PreparedStatement statement = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > 2");
    statement.execute();

    Integer count = statement.getUpdateCount();
    System.out.println("Quantidade de linhas afetadas: " + count);
  }
}
