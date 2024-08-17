package Contas;

import Funções.Tributo;

public class ContaCorrente extends Conta implements Tributo{
  public ContaCorrente(int agencia, int numero) {
    super(agencia, numero, "Conta Corrente");
  }

  @Override
  public void saque(double valor) {
    double valorSaque = valor + 0.5;
    super.saque(valorSaque);
  }

  @Override
  public void deposito(double valor) {
    super.saldo += valor;
  }

  @Override
  public double getValorImposto() {
    return super.saldo * 0.01;
  }
}
