public class TestaGetterSetter {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Rodrigo");
        cliente.setCPF("111111111-11");
        cliente.setProfissao("Dev");

        Conta conta = new Conta(1124, 112, cliente);
//        conta.setAgencia(1124);
//        conta.setNumero(112);
//        conta.setTitular(cliente);

        System.out.println("O número da conta é " + conta.getNumero());

        Conta conta2 = new Conta(1124, 232, cliente);

        System.out.println("O nome do cliente é " + conta.getTitular().getNome());
        System.out.println("O total de contas é " + Conta.getContador());
    }
}
