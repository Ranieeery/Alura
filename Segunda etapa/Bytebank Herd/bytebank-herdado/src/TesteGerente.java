public class TesteGerente {
  public static void main(String[] args) {
    Gerente g1 = new Gerente("João", "123.456.789-00", 5000.0, 1234);

    System.out.println(g1.getNome());
    System.out.println(g1.getBonificacao());

    System.out.println(g1.autenticacao(4321));
    System.out.println(g1.autenticacao(1234));

    System.out.println(g1.getSalario());
  }
}
