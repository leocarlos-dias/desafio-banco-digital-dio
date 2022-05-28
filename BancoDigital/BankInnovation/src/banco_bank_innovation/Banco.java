package banco_bank_innovation;
import banco_bank_innovation.conta.*;
import banco_bank_innovation.cliente.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    public static List<Conta> contaList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // CLIENTE1: Ciclano
        Cliente cliente01 = new Cliente();
        cliente01.setNome("Ciclano");
        cliente01.setCpf("123.456.789-01");

        // CLIENTE2: Fulano
        Cliente cliente02 = new Cliente();
        cliente02.setNome("Fulano");
        cliente02.setCpf("987.654.321-98");

        // CONTA CORRENTE DO Fulano, SALDO ATUAL: R$ 1.200,00
        ContaCorrente conta01 = new ContaCorrente(cliente01);
        conta01.setSaldo(1200);

        // CONTA CORRENTE DO LEANDRO, SALDO ATUAL: R$ 200,00
        ContaCorrente conta02 = new ContaCorrente(cliente02);
        conta02.setSaldo(200);


        ContaPoupanca conta03 = new ContaPoupanca(cliente01);
        ContaPoupanca conta04 = new ContaPoupanca(cliente02);

        contaList.add(conta01);
        contaList.add(conta02);
        contaList.add(conta03);
        contaList.add(conta04);

        System.out.println("==== Seja bem vindo ao BANCO INOVACAO! ====\n");

        listar(conta01, conta02, conta03, conta04);

        while (true) {
            System.out.println("Qual operacao deseja realizar?\n");
            System.out.println("1 - Depositar   \n2 - Sacar   \n3 - Transferir \n4 - Sair");
            System.out.print("\nDigite o numero da operacao: ");
            int operacao = scanner.nextInt();
            System.out.println("");

            if (operacao == 4) break;

            if (operacao == 3)
                System.out.println("\nATENCAO: Transferencia permitida somente entre contas do mesmo tipo\n Ex.: CC > CC / CP > CP\n");

            System.out.print("Digite o numero da sua conta: ");
            int conta = scanner.nextInt();
            while (conta > 4) {
                System.out.println("Conta invalida");
                System.out.print("Digite o numero da sua conta: ");
                conta = scanner.nextInt();
            }


            double valor;
            if (conta == 1) {
                if (operacao == 1) {
                    System.out.print("Qual valor deseja depositar? ");
                    valor = scanner.nextDouble();
                    conta01.depositar(valor);
                } else if (operacao == 2) {
                    System.out.print("Qual valor deseja Sacar? ");
                    valor = scanner.nextDouble();
                    conta01.sacar(valor);
                } else if (operacao == 3) {
                    System.out.printf("Qual valor deseja transferir? ");
                    valor = scanner.nextDouble();
                    conta01.transferir(valor, conta02);
                } else {
                    System.out.println("Operacao invalida!");
                }
            } else if (conta == 2) {
                if (operacao == 1) {
                    System.out.print("Qual valor deseja depositar? ");
                    valor = scanner.nextDouble();
                    conta02.depositar(valor);
                } else if (operacao == 2) {
                    System.out.print("Qual valor deseja Sacar? ");
                    valor = scanner.nextDouble();
                    conta02.sacar(valor);
                } else if (operacao == 3) {
                    System.out.printf("Qual valor deseja transferir? ");
                    valor = scanner.nextDouble();
                    conta02.transferir(valor, conta01);
                } else {
                    System.out.println("Operacao invalida!");
                }
            } else if (conta == 3) {
                if (operacao == 1) {
                    System.out.print("Qual valor deseja depositar? ");
                    valor = scanner.nextDouble();
                    conta03.depositar(valor);
                } else if (operacao == 2) {
                    System.out.print("Qual valor deseja Sacar? ");
                    valor = scanner.nextDouble();
                    conta02.sacar(valor);
                } else if (operacao == 3) {
                    System.out.printf("Qual valor deseja transferir? ");
                    valor = scanner.nextDouble();
                    conta03.transferir(valor, conta01);
                } else {
                    System.out.println("Operacao invalida!");
                }
            } else if (conta == 4) {
                if (operacao == 1) {
                    System.out.print("Qual valor deseja depositar? ");
                    valor = scanner.nextDouble();
                    conta03.depositar(valor);
                } else if (operacao == 2) {
                    System.out.print("Qual valor deseja Sacar? ");
                    valor = scanner.nextDouble();
                    conta02.sacar(valor);
                } else if (operacao == 3) {
                    System.out.printf("Qual valor deseja transferir? ");
                    valor = scanner.nextDouble();
                    conta04.transferir(valor, conta02);
                } else {
                    System.out.println("Operacao invalida!");
                }
            }

            System.out.println("");
            listar(conta01, conta02, conta03, conta04);
            System.out.println("\nDeseja realizar outra operacao?");
            System.out.print("1 - SIM  2 - NAO\n");
            int resposta = scanner.nextInt();
            if (resposta == 2) {
                System.out.println("ATE LOGO!");
                break;
            }
        }
    }

    private static void listar(Conta conta01, Conta conta02, ContaPoupanca conta03, ContaPoupanca conta04) {
        System.out.println("CONTA 01: Titular = " + conta01.cliente.getNome());
        System.out.print("Conta Corrente: ");
        System.out.print("Agencia: " + conta01.getAgencia());
        System.out.print(" - Numero: " + conta01.getNumero());
        System.out.println(" - Saldo: " + conta01.getSaldo());
        System.out.print("Conta Poupanca: ");
        System.out.print("Agencia: " + conta03.getAgencia());
        System.out.print(" - Numero: " + conta03.getNumero());
        System.out.println(" - Saldo: " + conta03.getSaldo());

        System.out.println("");

        System.out.println("CONTA 02: Titular = " + conta02.cliente.getNome());
        System.out.print("Conta Corrente: ");
        System.out.print("Agencia: " + conta02.getAgencia());
        System.out.print(" - Numero: " + conta02.getNumero());
        System.out.println(" - Saldo: " + conta02.getSaldo());
        System.out.print("Conta Poupanca: ");
        System.out.print("Agencia: " + conta04.getAgencia());
        System.out.print(" - Numero: " + conta04.getNumero());
        System.out.println(" - Saldo: " + conta04.getSaldo());

        System.out.println("");
    }
}
