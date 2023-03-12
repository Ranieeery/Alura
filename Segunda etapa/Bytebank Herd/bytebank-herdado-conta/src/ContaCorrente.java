public class ContaCorrente extends Conta{
  public ContaCorrente(int agencia, int numero) {
    super(agencia, numero, "Conta Corrente");
  }

  @Override
  public boolean saque(double valor) {
    double valorSaque = valor + 0.5;
    return super.saque(valorSaque);
  }

  @Override
  public void deposito(double valor) {
    super.saldo += valor;
  }
}
