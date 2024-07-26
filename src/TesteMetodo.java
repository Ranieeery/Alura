public class TesteMetodo {
    public static void main(String[] args) throws Exception {
        Conta contaPedro = new Conta();

        contaPedro.deposita(500);
        System.out.printf("O valor na conta é R$%.2f\n", contaPedro.saldo);

        contaPedro.saca(150);
        System.out.printf("O valor na conta é R$%.2f\n", contaPedro.saldo);

        Conta contaJoao = new Conta();

        contaJoao.deposita(200);
        contaJoao.transfere(120, contaJoao);
    }
}
