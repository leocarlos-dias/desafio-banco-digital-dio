package banco_bank_innovation.main;
import banco_bank_innovation.conta.*;
import banco_bank_innovation.cliente.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    public static List<Conta> contaList = new ArrayList<Conta>();
    public static List<Cliente> clienteList = new ArrayList<Cliente>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Cliente cliente01 = new Cliente();
        clienteList.add(cliente01);
        cliente01.setNome("Goku");
        cliente01.setCpf("661.632.738-02");

        Cliente cliente02 = new Cliente();
        clienteList.add(cliente02);
        cliente02.setNome("Vegeta");
        cliente02.setCpf("616.326.387-20");

        Conta conta01 = new ContaCorrente(cliente01);
        contaList.add(conta01);

        Conta conta02 = new ContaCorrente(cliente02);
        contaList.add(conta02);

        Conta conta03 = new ContaPoupanca(cliente01);
        contaList.add(conta03);

        Conta conta04 = new ContaPoupanca(cliente02);
        contaList.add(conta04);

        System.out.println("=================================\n" +
                "Seja bem vindo ao BANCO INOVACAO!\n" +
                "=================================");

        while (true) {
            System.out.print("\n * SELECIONE A OPERACAO DESEJADA:\n" +
                    "=== | 1 - DEPOSITAR\n" +
                    "=== | 2 - SACAR\n" +
                    "=== | 3 - TRANSFERIR\n" +
                    "=== | 4 - SAIR\n\n" +
                    "=== | OPERACAO: ");

            int tipoOperacao = scanner.nextInt();

            if (tipoOperacao == 4) break;
            if (tipoOperacao == 3) System.out.println("\nATENCAO: OPERACAO PERMITIDA SOMENTE PARA O MESMO TITULAR");


            System.out.print("=================================\n" +
                    "DIGITE O NUMERO DA CONTA: ");

            int acessarConta = scanner.nextInt();

            while (!(acessarConta <= 4)) {
                System.out.println("!!! NUMERO DA CONTA INVALIDA !!!\n");
                System.out.print("DIGITE O NUMERO DA CONTA: ");
                acessarConta = scanner.nextInt();
            }

            switch (tipoOperacao) {
                case 1:
                    System.out.print("DIGITE O VALOR PARA DEPOSITO: ");
                    double valorDeposita = scanner.nextDouble();
                    contaList.get(acessarConta - 1).depositar(valorDeposita);
                    break;
                case 2:
                    System.out.print("DIGITE O VALOR PARA SACAR: ");
                    double valorSaca = scanner.nextDouble();
                    contaList.get(acessarConta - 1).sacar(valorSaca);
                    break;
                case 3:
                    System.out.print("DIGITE O VALOR PARA TRANSFERIR: ");
                    double valorTransfere = scanner.nextDouble();

                    if (!(acessarConta <= 2)) {
                        System.out.println("CONTA POUPANCA DETECTADA");
                        Conta contaDestino = null;
                        switch (acessarConta) {
                            case 1:
                                contaDestino = conta01;
                            case 2:
                                contaDestino = conta02;
                        }
                        contaList.get(acessarConta - 1).transferir(valorTransfere, contaDestino);
                    } else {
                        System.out.println(" * CONTA CORRENTE DETECTADA * ");
                        Conta contaDestino = null;
                        switch (acessarConta) {
                            case 1:
                                contaDestino = conta03;
                                break;
                            case 2:
                                contaDestino = conta04;
                                break;
                        }
                        contaList.get(acessarConta - 1).transferir(valorTransfere, contaDestino);
                        break;
                    }
                case 4:
                    System.out.println("SAINDO....\nATE LOGO");
                    break;
                default:
                    System.out.println("OPERACAO INVALIDA");
            }
            System.out.println("");
            listar(conta01,conta02,conta03,conta04);
            System.out.println("\n* DESEJA REALIZAR OUTRA OPERACAO?");
            System.out.print(   "=== | 1 - SIM\n" +
                                "=== | 2 - NAO\n" +
                                "=== | : ");
            int resposta = scanner.nextInt();
            if (!(resposta == 1)) {
                System.out.println("OBRIGADO, ATE LOGO!");
                break;
            }
        }
    }

    private static void listar(Conta conta01, Conta conta02, Conta conta03, Conta conta04) {
        System.out.println("====================================================");
        System.out.println("CONTA 01 - Titular = " + conta01.getCliente().getNome());
        System.out.print("Conta Corrente: ");
        System.out.print("Agencia: " + conta01.getAgencia());
        System.out.print(" - Numero: " + conta01.getNumero());
        System.out.println(" - Saldo: " + conta01.getSaldo());
        System.out.print("Conta Poupanca: ");
        System.out.print("Agencia: " + conta03.getAgencia());
        System.out.print(" - Numero: " + conta03.getNumero());
        System.out.println(" - Saldo: " + conta03.getSaldo());

        System.out.println("");

        System.out.println("CONTA 02: Titular = " + conta02.getCliente().getNome());
        System.out.print("Conta Corrente: ");
        System.out.print("Agencia: " + conta02.getAgencia());
        System.out.print(" - Numero: " + conta02.getNumero());
        System.out.println(" - Saldo: " + conta02.getSaldo());
        System.out.print("Conta Poupanca: ");
        System.out.print("Agencia: " + conta04.getAgencia());
        System.out.print(" - Numero: " + conta04.getNumero());
        System.out.println(" - Saldo: " + conta04.getSaldo());
        System.out.println("====================================================");
        System.out.println("");
    }
}