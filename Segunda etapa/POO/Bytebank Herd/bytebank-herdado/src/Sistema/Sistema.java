package Sistema;

public class Sistema {
  private int senha = 2323;

  public boolean autentica(Autenticavel a) {
    return a.autenticacao(this.senha);
  }
}
