public class TesteMetodo {
    public static void main(String[] args) {
        Conta contaPedro = new Conta();

        contaPedro.deposita(500);
        System.out.printf("O valor na conta de Pedro é R$%.2f\n", contaPedro.saldo);

        contaPedro.saca(150);
        System.out.printf("O valor na conta de Pedro é R$%.2f\n", contaPedro.saldo);

        Conta contaJoao = new Conta();

        contaJoao.deposita(200);
        System.out.printf("O valor na conta de João é R$%.2f\n", contaJoao.saldo);

        System.out.println(contaJoao.transfere(120, contaPedro)
            ? "Transferência realizada"
            : "Saldo insuficiente para transferência");

        System.out.printf("O valor na conta de Pedro é R$%.2f\n", contaPedro.saldo);
        System.out.printf("O valor na conta de João é R$%.2f\n", contaJoao.saldo);
    }
}
