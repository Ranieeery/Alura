public class TryCatch {
  public static void main(String[] args) {
    try {

      int a = 1/0;
      System.out.println("Resultado: " + a);

      // Fluxo b = null;
      // System.out.println(b.getClass());

      // char c = 'c';
      // throw new ArithmeticException("Erro: " + c);

    } catch (ArithmeticException | NullPointerException e) {
      System.out.println("Erro: " + e.getMessage());
      e.printStackTrace();
    } finally {
      System.out.println("Fim do programa");
    }

    //Checked: São exceções que são verificadas em tempo de compilação.
    //Unchecked: São exceções que não são verificadas em tempo de compilação.
  }
}
