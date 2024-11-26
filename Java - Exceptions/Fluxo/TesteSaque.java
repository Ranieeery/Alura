public class TesteSaque {
    public static void main(String[] args) {
        Conta conta = new Conta();

        conta.deposita(200);

        try {
            conta.saca(210);
        } catch (MyException ex) {
            ex.printStackTrace();
        }

        System.out.println(conta.getSaldo());
    }
}
