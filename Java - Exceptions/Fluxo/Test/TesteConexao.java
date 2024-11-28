package Test;

import Model.Conexao;

public class TesteConexao {
    public static void main(String[] args) {

        // try-with-resources
        try (Conexao conexao = new Conexao()) {
            conexao.leDados();
        } catch (IllegalStateException ex) {
            System.out.println("Erro na conexão");
        }

        //----------------------------------------------

        // try-catch-finally
        Conexao con = null;

        try {
            con = new Conexao();
            con.leDados();
        } catch (IllegalStateException ex) {
            System.out.println("Erro na conexão");
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
