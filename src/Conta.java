class Conta {
    double saldo;
    int agencia;
    int numero;
    String titular;

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public void saca(double valor){
        this.saldo -= valor;
    }

    public boolean transfere(double valor, Conta contatrans) throws Exception{
        if (this.saldo <= valor) throw new Exception("Saldo insuficiente para a transferência");
            this.saca(valor);
            contatrans.deposita(valor);
            return true;
        }

}