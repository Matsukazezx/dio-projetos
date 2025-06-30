import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente teste = new Cliente();
        teste.setNome("Teste");

        Conta cc = new ContaCorrente(teste);
        Conta poupanca = new ContaPoupanca(teste);

        cc.depositar(500);
        cc.transferir(300, poupanca);

        Banco banco = new Banco();
        banco.setNome("Banco Digital Inazuma");
        banco.setContas(new ArrayList<>());
        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        List<Conta> contasDoCliente = banco.listarContasPorCliente("Teste");
        for (Conta conta : contasDoCliente) {
            conta.imprimirExtrato();
            System.out.println("-------------------");
        }
    }
}
