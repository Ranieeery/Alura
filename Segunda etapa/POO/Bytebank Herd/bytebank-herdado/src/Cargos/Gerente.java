package Cargos;

import Sistema.*;

public class Gerente extends Funcionario implements Autenticavel{

  private AutenticavelCliente autenticador;
  

  public Gerente(String nome, String cpf, double salario, int senha) {
    super(nome, cpf, salario);
    this.autenticador = new AutenticavelCliente();
    setSenha(senha);
  }

  public double getBonificacao() {
    return super.getSalario();
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
  public String getCargo() {
    return "Gerente";
  }

  // Com protected, não é necessário o uso do super
  // public double getBonificacao() {
  //   return this.getSalario();
  // }  
}
    