import Contas.Conta;
import Contas.ContaCorrente;
import Funções.SaldoInsuficienteException;

public class TesteSaqueException {
  public static void main(String[] args) {
    Conta conta = new ContaCorrente(001, 4002);
    conta.deposito(250);

    try {
      conta.saque(250);
    } catch (SaldoInsuficienteException e) {
      e.printStackTrace();
      System.out.println("------------------------------------------------------------------");
    }

    System.out.println(conta.getSaldo());
  }
}
