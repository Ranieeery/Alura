public class TesteReferencias {
  public static void main(String[] args) {
    Gerente g1 = new Gerente("Caio", "111.222.333-00", 2500, 1230);
    Funcionario f1 = new Funcionario("João", "123.456.789-00", 1500);
    Secretario s1 = new Secretario("Paula", "987.654.321-00", 2000);

    ControleBonificacao controle = new ControleBonificacao();
    controle.registra(g1);
    controle.registra(f1);
    controle.registra(s1);

    System.out.println(controle.getSoma());
  }
  
}
