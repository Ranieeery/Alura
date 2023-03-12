public class ContaPoupanca extends Conta{
  public ContaPoupanca(int agencia, int numero) {
    super(agencia, numero, "Conta Poupança");
  }

  @Override
  public void deposito(double valor) {
    super.saldo += valor;
  }
}
