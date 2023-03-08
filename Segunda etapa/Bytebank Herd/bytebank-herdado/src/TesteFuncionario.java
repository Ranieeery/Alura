public class TesteFuncionario {
  public static void main(String[] args) {
    Funcionario func = new Funcionario("Pedro Delesporte", "123.456.789-00", 2500);
    System.out.println(func.getNome());
    System.out.println(func.getBonificacao());

    Gerente ger = new Gerente("João da Silva", "987.654.321-00", 5000, 1234);
    System.out.println(ger.getNome());
    System.out.println(ger.getBonificacao());
  }
}
