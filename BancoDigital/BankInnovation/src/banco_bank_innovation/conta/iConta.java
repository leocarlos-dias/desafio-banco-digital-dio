package banco_bank_innovation.conta;

public interface iConta {

    void depositar(double valor);
    void sacar(double valor);
    void transferir(double valor, Conta contaDestino);
}
