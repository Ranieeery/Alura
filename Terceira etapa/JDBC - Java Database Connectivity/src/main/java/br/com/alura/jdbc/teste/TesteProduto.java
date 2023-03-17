package br.com.alura.jdbc.teste;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;
import br.com.alura.jdbc.modelo.ProdutoDAO;

public class TesteProduto {
  public static void main(String[] args) throws SQLException{
    Produto produto = new Produto("TV", "Televisão de 50 polegadas");

    try (Connection connection = new ConnectionFactory().recupConnection()) {
      // new PersistenciaProduto(connection).saveProduto(produto);
      ProdutoDAO produtoDAO = new ProdutoDAO(connection);
      produtoDAO.saveProduto(produto);

      List<Produto> listaProdutos = produtoDAO.listProdutos();
      listaProdutos.stream().forEach(lista -> System.out.println(lista));
    }

    System.out.println(produto);
  }
}
