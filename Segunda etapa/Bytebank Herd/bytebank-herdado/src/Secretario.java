public class Secretario extends Funcionario {

  public Secretario(String nome, String cpf, double salario) {
    super(nome, cpf, salario);
  }

  public double getBonificacao() {
    return super.getBonificacao() + 100;
  }
}
