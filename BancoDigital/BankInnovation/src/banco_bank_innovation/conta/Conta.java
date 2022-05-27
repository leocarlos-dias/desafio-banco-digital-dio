package banco_bank_innovation.conta;

import banco_bank_innovation.cliente.*;

import static banco_bank_innovation.Banco.contaList;

public abstract class Conta implements iConta {

    protected int numero;
    protected int agencia;
    protected double saldo;
    public Cliente cliente;

    private static final int AGENCIA_PRINCIPAL = 1;
    private static int SEQUENCIA_CONTA = 1;

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Conta.total = total;
    }

    private static int total = 0;


    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PRINCIPAL;
        this.numero = Conta.SEQUENCIA_CONTA++;
        this.cliente = cliente;
        Conta.total++;
    }

    @Override
    public void sacar(double valor) {
        boolean resultado = (this.saldo - valor) < 0;
        if (resultado == false){
            this.saldo -= valor;
        }
        System.out.println("Saldo insuficiente");
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        boolean resultado = (this.saldo - valor) < 0;

        if (resultado == false){
            this.saldo -= valor;
            contaDestino.saldo += valor;
        }
        System.out.println("Saldo insuficiente");
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
