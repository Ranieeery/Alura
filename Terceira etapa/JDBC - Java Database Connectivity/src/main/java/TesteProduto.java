import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

public class TesteProduto {
  public static void main(String[] args) throws SQLException{
    Produto produto = new Produto("TV", "Televisão de 50 polegadas");

    try (Connection connection = new ConnectionFactory().recupConnection()) {
      String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)";

      try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        preparedStatement.setString(1, produto.getNome());
        preparedStatement.setString(2, produto.getDescricao());

        preparedStatement.execute();

        try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
          while (resultSet.next()) {
            produto.setId(resultSet.getInt(1));
          }
        }
      }
    }

    System.out.println(produto);
  }
}
