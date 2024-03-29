class Conta {
    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total;

    public Conta(int agencia, int numero) {
        Conta.total++;
        this.agencia = agencia;
        this.numero = numero;
        System.out.println("Estou criando uma conta " + this.numero);
        System.out.println("O total de contas existentes é " + Conta.total);
    }

    public void deposito(double valor) {
        this.saldo += valor;
    }

    public boolean saque(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else
            return false;
    }

    public boolean transfere(double valor, Conta destino) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.deposito(valor);
            return true;
        } else
            return false;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setTitular(Cliente titular) {
      this.titular = titular;
    }

    public static int getTotal() {
      return Conta.total;
    }
}