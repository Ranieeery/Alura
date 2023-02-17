public class TesteGetSet {
  public static void main(String[] args) {
    Conta conta = new Conta();

    conta.setNumero(1337);
    System.out.println(conta.getNumero());

    Cliente robertoCliente = new Cliente();
    robertoCliente.setNome("Roberto");

    conta.setTitular(robertoCliente);

    System.out.println(conta.getTitular().getNome());
    
  }
}
