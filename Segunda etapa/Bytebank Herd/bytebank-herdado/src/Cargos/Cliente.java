package Cargos;

import Sistema.Autenticavel;

public class Cliente implements Autenticavel {

  private int senha;

  @Override
  public void setSenha(int senha) {
    this.senha = senha;
  }

  @Override
  public boolean autenticacao(int senha) {
    return this.senha == senha ? true : false;
  }

}
