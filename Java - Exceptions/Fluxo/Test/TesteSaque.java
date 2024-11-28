package Test;

import Model.Conta;
import Model.ContaCorrente;
import Model.SaldoInsuficienteException;

public class TesteSaque {
    public static void main(String[] args) {
        Conta conta = new ContaCorrente(1, 1003);

        conta.deposita(200);

        try {
            conta.saca(210);
        } catch (SaldoInsuficienteException ex) {
            ex.printStackTrace();
        }

        System.out.println(conta.getSaldo());
    }
}
