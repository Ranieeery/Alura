import Cargos.*;
import Sistema.*;

public class TesteSistema {
  public static void main(String[] args) {
    Gerente g1 = new Gerente("João", "123.456.789-00", 5000.0, 2323);
    Administrador adm = new Administrador("Maria", "987.654.321-00", 3000.0, 1234);
    Cliente cl = new Cliente(2323);
    Sistema s1 = new Sistema();

    System.out.println();

    System.out.println(s1.autentica(g1) ? "Acesso permitido para " + g1.getCargo() : "Acesso negado para " + g1.getCargo());
    System.out.println(s1.autentica(adm) ? "Acesso permitido para " + adm.getCargo() : "Acesso negado para " + adm.getCargo());
    System.out.println(s1.autentica(cl) ? "Acesso permitido para " + cl.getCargo() : "Acesso negado para " + cl.getCargo());
  }
}
