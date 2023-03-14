package Sistema;

public class AutenticavelCliente {
  private int senha;

  public void setSenha(int senha) {
    this.senha = senha;
  }

  public boolean autenticacao(int senha) {
    return this.senha == senha ? true : false;
  }

}
