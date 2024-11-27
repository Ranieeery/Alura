package Test;

import Model.Conta;
import Model.MyException;

@SuppressWarnings("CallToPrintStackTrace")
public class FluxoChecked {
    public static void main(String[] args) {
        Conta conta = new Conta();
        try {
            conta.deposita();

        } catch (MyException ex) {
            ex.printStackTrace();
        }
    }
}
