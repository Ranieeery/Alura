package Funções;

public class CalculadoraImposto implements Tributo {

  private double totalImposto;

  public void registra(Tributo t) {
    double valor = t.getValorImposto();
    this.totalImposto += valor;
  }

  @Override
  public double getValorImposto() {
    return totalImposto;
  }

}