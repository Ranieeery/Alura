public class CriaConta {
    public static void main(String[] args) {

        Conta conta1 = new Conta();
        conta1.saldo = 200;
        conta1.agencia = 1234;
        conta1.numero = 123456;

        conta1.saldo += 100;

        System.out.printf("O saldo da primeira conta é: %.2f\n", conta1.saldo);
        System.out.println("A agência da primeira conta é: " + conta1.agencia);
        System.out.println("O número da primeira conta é: " + conta1.numero);

        Conta conta2 = new Conta();
        conta2.saldo = 100;
        conta2.agencia = 4321;
        conta2.numero = 654321;

        System.out.printf("O saldo da segunda conta é: %.2f\n", conta2.saldo);
        System.out.println("A agência da segunda conta é: " + conta2.agencia);
        System.out.println("O número da segunda conta é: " + conta2.numero);
    }
}
