public class Administrador extends FuncionarioAutenticavel {

  public Administrador(String nome, String cpf, double salario, int senha) {
    super(nome, cpf, salario);
    this.senha = senha;
  }

  @Override
  public double getBonificacao() {
    return 500;
  }

}
