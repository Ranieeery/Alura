public class TesteContas {
  public static void main(String[] args) {
    ContaCorrente cc = new ContaCorrente(111, 222);
    cc.deposito(100);

    ContaPoupanca cp = new ContaPoupanca(222, 111);
    cp.deposito(200);
    
    cc.transfere(25, cp);
    System.out.println("CC: " + cc.getSaldo());
    System.out.println("CP: " + cp.getSaldo());

  }
  
}
