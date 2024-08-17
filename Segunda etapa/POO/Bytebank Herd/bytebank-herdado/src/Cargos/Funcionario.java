package Cargos;
public abstract class Funcionario {
  private String nome;
  private String cpf;
  private double salario;
//  protected double salario;

  public Funcionario(String nome, String cpf, double salario) {
    this.nome = nome;
    this.cpf = cpf;
    this.salario = salario;
    System.out.printf("Funcionário %s, CPF %s com salário de R$%.2f criado com sucesso!%n", this.nome, this.cpf, this.salario);
  }

  // Método abstract não tem corpo, mas é obrigatório que as classes filhas o implementem
  public abstract double getBonificacao();

  public abstract String getCargo();

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
