public class TesteSaqueNegativo {
  public static void main(String[] args) {
    Conta conta = new Conta();
    conta.deposito(100);
    conta.saque(200);
    System.out.println(conta.getSaldo());
  }
}
