public class TestaMetodo {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.saldo = 100;
        conta.deposito(50);
        System.out.println(conta.saldo);
        var conseguiuRetirar = conta.saque(20);
        System.out.println(conta.saldo);
        System.out.println(conseguiuRetirar);

        Conta conta2 = new Conta();
        conta2.deposito(1000);
        if (conta2.transfere(300, conta)) {
            System.out.println("Transferência realizada com sucesso");
        } else {
            System.out.println("Faltou dinheiro");
        }
        System.out.println(conta.saldo);
        System.out.println(conta2.saldo);
    }

}
