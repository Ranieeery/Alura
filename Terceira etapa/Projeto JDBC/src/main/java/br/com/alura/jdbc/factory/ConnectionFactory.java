package br.com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

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

		this.dataSource = comboPooledDataSource;
	}

	public Connection recuperarConexao() {
		try {
			return this.dataSource.getConnection();
	} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
