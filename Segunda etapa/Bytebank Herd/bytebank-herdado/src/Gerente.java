public class Gerente extends FuncionarioAutenticavel{

  public Gerente(String nome, String cpf, double salario, int senha) {
    super(nome, cpf, salario);
    this.senha = senha;
  }

  public double getBonificacao() {
    return super.getSalario();
  }

  // Com protected, não é necessário o uso do super
  // public double getBonificacao() {
  //   return this.getSalario();
  // }  
}
    