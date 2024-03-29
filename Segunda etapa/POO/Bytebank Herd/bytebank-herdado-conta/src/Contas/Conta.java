package Contas;

import Funções.SaldoInsuficienteException;

public abstract class Conta {
    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total = 0;

    public Conta(int agencia, int numero) {
        Conta.total++;
        this.agencia = agencia;
        this.numero = numero;
        this.titular = new Cliente();
        System.out.println("Estou criando uma conta " + this.numero);
        System.out.println("O total de contas existentes é " + Conta.total);
    }

    public Conta(int agencia, int numero, String tipoConta) {
        Conta.total++;
        this.agencia = agencia;
        this.numero = numero;
        System.out.println("Estou criando uma conta " + this.numero + " do tipo: " + tipoConta);
        System.out.println("O total de contas existentes é " + Conta.total);
    }
    
    public abstract void deposito(double valor);

    public void saque(double valor) {
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException("Saldo: " + this.saldo + " | Valor: " + valor);
        }
        this.saldo -= valor;
    }

    public void transfere(double valor, Conta destino) {
        this.saque(valor);
        destino.deposito(valor);
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