public class TesteChecked {
  // Checked são exceções que são verificadas em tempo de compilação.

  // public static void main(String[] args) throws Excecao {
  //   TesteThrows t = new TesteThrows();
  //   t.recebe();
  // }

  public static void main(String[] args) {
    TesteThrows t = new TesteThrows();
    try {
      t.recebe();
    } catch (Excecao e) {
      e.printStackTrace();
    }
  }
}
