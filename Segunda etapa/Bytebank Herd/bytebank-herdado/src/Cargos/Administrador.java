package Cargos;

import Sistema.*;

public class Administrador extends Funcionario implements Autenticavel {

  private AutenticavelCliente autenticador;

  public Administrador(String nome, String cpf, double salario, int senha) {
    super(nome, cpf, salario);
    this.autenticador = new AutenticavelCliente();
    setSenha(senha);
  }

  @Override
  public void setSenha(int senha) {
    this.autenticador.setSenha(senha);
  }

  @Override
  public boolean autenticacao(int senha) {
    return this.autenticador.autenticacao(senha);
  }

  @Override
  public double getBonificacao() {
    return 500;
  }

  @Override
  public String getCargo() {
    return "Administrador";
  }

}
