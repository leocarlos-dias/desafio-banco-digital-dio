package banco_bank_innovation.conta;
import banco_bank_innovation.cliente.Cliente;

public class ContaCorrente extends Conta {
    Cliente cliente;
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

}
