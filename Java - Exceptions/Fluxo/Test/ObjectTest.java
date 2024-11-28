package Test;

import Model.ContaCorrente;
import Model.ContaPoupanca;

public class ObjectTest {
    public static void main(String[] args) {

        Object cc = new ContaCorrente(1, 3003);
        Object cp = new ContaPoupanca(2, 3004);

        println(cc);
        println(cp);

    }

    static void println() {

    }

    static void println(int a) {

    }

    static void println(boolean a) {

    }

    static void println(Object conta) {

    }
}
