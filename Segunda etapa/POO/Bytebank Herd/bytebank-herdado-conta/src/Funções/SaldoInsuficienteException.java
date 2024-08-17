package Funções;

public class SaldoInsuficienteException extends RuntimeException {
  public SaldoInsuficienteException() {
    super();
}

  public SaldoInsuficienteException(String message) {
    super(message);
}

  public SaldoInsuficienteException(String message, Throwable cause) {
    super(message, cause);
}

  public SaldoInsuficienteException(Throwable cause) {
    super(cause);
}

  protected SaldoInsuficienteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
}
}
