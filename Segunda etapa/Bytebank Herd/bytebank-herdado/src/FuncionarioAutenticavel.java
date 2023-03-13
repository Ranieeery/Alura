public abstract class FuncionarioAutenticavel extends Funcionario {
  protected int senha;

  public FuncionarioAutenticavel(String nome, String cpf, double salario) {
    super(nome, cpf, salario);
  }

  public boolean autenticacao(int senha) {
    if (this.senha == senha) {
      System.out.println("Acesso permitido!");
      return true;
    } else {
      System.out.println("Acesso negado!");
      return false;
    }
  }
}
