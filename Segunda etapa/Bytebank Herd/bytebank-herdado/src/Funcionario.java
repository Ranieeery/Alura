public class Funcionario {
  private String nome;
  private String cpf;
  private double salario;

  public Funcionario(String nome, String cpf, double salario) {
    this.nome = nome;
    this.cpf = cpf;
    this.salario = salario;
    System.out.printf("Funcionário %s, CPF %s com salário de R$%.2f criado com sucesso!%n", this.nome, this.cpf, this.salario);
  }

  public double getBonificacao() {
    return this.salario * 0.1;
  }

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  public double getSalario() {
    return salario;
  }
  public void setSalario(double salario) {
    this.salario = salario;
  }
}
