package Cargos;

import Sistema.Autenticavel;

public class Gerente extends Funcionario implements Autenticavel{

  private int senha;

  public Gerente(String nome, String cpf, double salario, int senha) {
    super(nome, cpf, salario);
    setSenha(senha);
  }

  public double getBonificacao() {
    return super.getSalario();
  }

  @Override
  public void setSenha(int senha) {
    this.senha = senha;
  }

  @Override
  public boolean autenticacao(int senha) {
    return this.senha == senha ? true : false;
  }

  // Com protected, não é necessário o uso do super
  // public double getBonificacao() {
  //   return this.getSalario();
  // }  
}
    