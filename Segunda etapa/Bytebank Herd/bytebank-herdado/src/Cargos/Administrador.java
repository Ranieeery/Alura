package Cargos;

import Sistema.Autenticavel;

public class Administrador extends Funcionario implements Autenticavel {

  private int senha;

  public Administrador(String nome, String cpf, double salario, int senha) {
    super(nome, cpf, salario);
    setSenha(senha);
  }

  @Override
  public void setSenha(int senha) {
    this.senha = senha;
  }

  @Override
  public double getBonificacao() {
    return 500;
  }

  @Override
  public boolean autenticacao(int senha) {
    return this.senha == senha ? true : false;
  }

}
