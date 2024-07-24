public class TesteReferencia {

    public static void main(String[] args) {
        Conta conta1 = new Conta();
        conta1.saldo = 200;

        Conta conta2 = conta1;

        System.out.println(conta1); // imprime o endereço de memória
        System.out.println(conta2); // O mesmo endereço de memória

        conta2.saldo = 300;

        System.out.println(conta1.saldo);
        System.out.println(conta2.saldo);

        if (conta1 == conta2) {
            System.out.println("São a mesma conta");
        }
    }
}
