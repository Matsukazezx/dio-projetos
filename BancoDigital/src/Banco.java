import java.util.List;
import java.util.stream.Collectors;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public Conta buscarContaPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public List<Conta> listarContasPorCliente(String nomeCliente) {
        return contas.stream()
                .filter(c -> c.getCliente().getNome().equalsIgnoreCase(nomeCliente))
                .collect(Collectors.toList());
    }

}