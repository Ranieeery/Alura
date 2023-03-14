public class TesteSemCliente {
  public static void main(String[] args) {
    Conta contaTeste2 = new Conta();
    System.out.println(contaTeste2.getSaldo());
    contaTeste2.titular = new Cliente();
    contaTeste2.titular.cpf = "123.456.789-12";
    System.out.println(contaTeste2.titular.cpf);
  }
}
