public class Gerente extends Funcionario{
  private int senha;

  public Gerente(String nome, String cpf, double salario, int senha) {
    super(nome, cpf, salario);
    this.senha = senha;
  }

  public double getBonificacao() {
    return super.getSalario();
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
