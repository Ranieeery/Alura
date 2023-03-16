package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class TesteAdd {
  public static void main(String[] args) throws SQLException {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    Connection connection = connectionFactory.recupConnection();

    Statement statement = connection.createStatement();
    statement.execute("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ('Mouse', 'Mouse sem fio')",
        Statement.RETURN_GENERATED_KEYS);
    ResultSet resultSet = statement.getGeneratedKeys();

    while (resultSet.next()) {
      Integer id = resultSet.getInt(1);
      System.out.println("O id criado foi: " + id);
    }
  }
}
