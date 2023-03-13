public class Sistema {
  private int senha = 2323;

  public void autentica(FuncionarioAutenticavel f) {
    f.autenticacao(this.senha);
  }
}
