public class TesteSaqueNegativo {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.deposita(100);

        conta.saca(200);
        System.out.printf("O valor na conta é R$%.2f\n", conta.getSaldo());
    }
}
