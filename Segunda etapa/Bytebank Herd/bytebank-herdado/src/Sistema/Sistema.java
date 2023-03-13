package Sistema;

public class Sistema {
  private int senha = 2323;

  public void autentica(Autenticavel a) {
    a.autenticacao(this.senha);
  }
}
