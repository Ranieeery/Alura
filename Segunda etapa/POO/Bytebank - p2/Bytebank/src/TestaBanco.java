public class TestaBanco {
  public static void main(String[] args) {
    Cliente teste = new Cliente();
    teste.nome = "Teste da Silva";
    teste.cpf = "123.456.789-00";
    teste.profissao = "Desenvolvedor Java";

    Conta contaTeste = new Conta();
    contaTeste.deposito(200);

    contaTeste.titular = teste;
    System.out.println(contaTeste.titular.nome);
  }
}
