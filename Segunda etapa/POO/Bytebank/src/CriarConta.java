public class CriarConta {
    public static void main(String[] args) {
        Conta primeiraConta = new Conta();
        primeiraConta.saldo = 200;
        System.out.println(primeiraConta.saldo);

        primeiraConta.saldo += 100;
        System.out.println(primeiraConta.saldo);

        Conta segundaConta = new Conta();
        segundaConta.saldo = 50;

        System.out.printf("O saldo da primeira conta é R$%.2f\n", primeiraConta.saldo);
        System.out.printf("O saldo da segunda conta é R$%.2f\n", segundaConta.saldo);

        System.out.println(primeiraConta.agencia);
        System.out.println(primeiraConta.titular);
    }
}