package Cargos;

import Sistema.*;;

public class Cliente implements Autenticavel {
  private String cargo = "Cliente";
  private AutenticavelCliente autenticador;

  public Cliente(int senha) {
    this.autenticador = new AutenticavelCliente();
    System.out.println("Cliente registrado");
    setSenha(senha);
  }

  
  public String getCargo() {
    return cargo;
  }
  
  @Override
  public void setSenha(int senha) {
    this.autenticador.setSenha(senha);
  }

  @Override
  public boolean autenticacao(int senha) {
    return this.autenticador.autenticacao(senha);
  }

}
