public class Conta {
    private double saldo;

    public void deposita() throws MyException {
        throw new MyException("Método não implementado");
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public void saca(double valor) throws MyException {
        if (this.saldo < valor) {
            throw new MyException("Saldo insuficiente");
        } else {
            this.saldo -= valor;
        }
    }

    public double getSaldo() {
        return this.saldo;
    }
}
