package br.com.alura.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class TesteAdd {
  public static void main(String[] args) throws SQLException {
    String nome = JOptionPane.showInputDialog("Digite o nome do produto").toUpperCase();
    String descricao = JOptionPane.showInputDialog("Digite a descrição do produto").toUpperCase();

    ConnectionFactory connectionFactory = new ConnectionFactory();
    try (Connection connection = connectionFactory.recupConnection()) {
      connection.setAutoCommit(false);

      try (PreparedStatement statement = connection
          .prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)",
              Statement.RETURN_GENERATED_KEYS)) {

        ConnectionFactory.addVar(nome, descricao, statement);
        // ConnectionFactory.addVar("RÁDIO", "RADIO DE BATERIA", statement);

        connection.commit();
        statement.close();
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Rollback executado");
        connection.rollback();
      }
    }
  }
}
