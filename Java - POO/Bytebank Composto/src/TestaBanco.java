public class TestaBanco {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.nome = "Pedro";
        cliente.CPF = "123.456.789";
        cliente.profissao = "Programador";

        Conta conta = new Conta();
        conta.deposita(100);
        conta.titular = cliente;
        System.out.println("O titular da conta é: " + conta.titular.nome);

    }
}
