import Sistema.Conexao;

public class TesteConexao {
  public static void main(String[] args) {

    try (Conexao conexao = new Conexao()) {
      conexao.readData();
    } catch (IllegalStateException e) {
      System.out.println("Erro na conexão");
      e.printStackTrace();
    }

    // -----------------------------------------------------

    Conexao conexao = null;

    try {
      conexao = new Conexao();
      conexao.readData();
    } catch (IllegalStateException e) {
      System.out.println("Erro na conexão");
    } finally {
      if (conexao != null) {
        conexao.close();
      }
    }

    // -----------------------------------------------------

    try {
      conexao = new Conexao();
      conexao.readData();
    } finally {
      conexao.close();
    }
  }
}
