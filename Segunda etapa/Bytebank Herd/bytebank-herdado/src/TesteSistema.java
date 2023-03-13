import Cargos.*;
import Sistema.*;

public class TesteSistema {
  public static void main(String[] args) {
    Gerente g1 = new Gerente("João", "123.456.789-00", 5000.0, 2323);
    Administrador adm = new Administrador("Maria", "987.654.321-00", 3000.0, 1234);

    Sistema s1 = new Sistema();
    s1.autentica(g1);
    s1.autentica(adm);
      
  }
}
