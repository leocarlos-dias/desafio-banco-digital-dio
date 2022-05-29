package banco_bank_innovation.conta;

import banco_bank_innovation.cliente.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Conta implements iConta {

    protected int numero;
    protected int agencia;
    protected double saldo;

    protected Cliente cliente;

    private static final int AGENCIA_PRINCIPAL = 1;
    private static int SEQUENCIA_CONTA = 1;

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Conta.total = total;
    }

    private static int total = 0;

    public Conta (Cliente titular) {
        this.agencia = Conta.AGENCIA_PRINCIPAL;
        this.numero = Conta.SEQUENCIA_CONTA++;
        this.saldo = 0.0;
        this.cliente = titular;
        Conta.total++;

    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    @Override
    public void sacar(double valor) {
        boolean saldoAposTransacao = (this.saldo - valor) > 0;
        boolean valorPositivo = (valor > 0);

        if (!saldoAposTransacao || !valorPositivo) {
            System.out.println("\n!!! SALDO INSUFICIENTE !!!");
        } else {
            this.saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {
        boolean valorPositivo = (valor > 0);
        if (!valorPositivo) {
            System.out.println("\n!!! VERIFIQUE O VALOR DE DEPOSITO !!!");
        } else {
            this.saldo += valor;
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        boolean saldoAposTransacao = (this.saldo - valor) > 0;
        boolean valorPositivo = (valor > 0);
        if (!saldoAposTransacao || !valorPositivo) {
            System.out.println("\n!!! SALDO INSUFICIENTE !!!");
        } else {
            this.saldo -= valor;
            contaDestino.saldo += valor;
        }
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
