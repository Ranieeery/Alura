public class Excecao extends Exception {
  public Excecao() {
    super();
  }

  public Excecao(String message) {
    super(message);
  }

  public Excecao(Throwable cause) {
    super(cause);
  }

  public Excecao(String message, Throwable cause) {
    super(message, cause);
  }

  protected Excecao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
