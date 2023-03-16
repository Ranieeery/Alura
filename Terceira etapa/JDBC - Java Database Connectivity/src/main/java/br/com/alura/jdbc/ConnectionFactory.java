package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactory {
  public Connection recupConnection() throws SQLException {
    Dotenv dotenv = Dotenv.load();
    String dbUser = dotenv.get("USER");
    String dbPassword = dotenv.get("PASSWORD");

    return DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/loja_virtual", dbUser, dbPassword);
  }
}
