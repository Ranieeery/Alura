public class TesteGetSet {
  public static void main(String[] args) {
    Conta conta = new Conta(1337, 24226);
    System.out.println(conta.getAgencia());

    Conta conta1 = new Conta(3127, 18642);
    System.out.println(conta1.getAgencia());

    Conta conta2 = new Conta(9523, 41867);
    System.out.println(conta2.getAgencia());
    
    System.out.println("O total de contas é " + Conta.getTotal());
  }
}
