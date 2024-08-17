package br.com.alura.jdbc;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactory {

  public DataSource dataSource;
  
  public ConnectionFactory() {
    Dotenv dotenv = Dotenv.load();
    String dbUser = dotenv.get("USER");
    String dbPassword = dotenv.get("PASSWORD");
    ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/loja_virtual");
    comboPooledDataSource.setUser(dbUser);
    comboPooledDataSource.setPassword(dbPassword);

    comboPooledDataSource.setMaxPoolSize(15);
    
    this.dataSource = comboPooledDataSource;
  }
  
  public Connection recupConnection() throws SQLException {
    return this.dataSource.getConnection();
  }

  public static void addVar(String nome, String descricao, PreparedStatement statement) throws SQLException {
    statement.setString(1, nome);
    statement.setString(2, descricao);

    statement.execute();
    try (ResultSet resultSet = statement.getGeneratedKeys()) {

      while (resultSet.next()) {
        Integer id = resultSet.getInt(1);
        System.out.println("O id criado foi: " + id);
      }
    }
  }
}
