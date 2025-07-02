package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Pedido;
import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.repository.PedidoRepository;
import one.digitalinnovation.gof.repository.ClienteRepository;
import one.digitalinnovation.gof.repository.EnderecoRepository;
import one.digitalinnovation.gof.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Iterable<Pedido> buscarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    @Override
    public void inserir(Pedido pedido) {
        salvarPedido(pedido);
    }

    @Override
    public void atualizar(Long id, Pedido pedido) {
        if (pedidoRepository.existsById(id)) {
            pedido.setId(id);
            salvarPedido(pedido);
        }
    }

    @Override
    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    private void salvarPedido(Pedido pedido) {
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Endereco endereco = enderecoRepository.findById(pedido.getEnderecoEntrega().getCep())
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        pedido.setCliente(cliente);
        pedido.setEnderecoEntrega(endereco);

        pedidoRepository.save(pedido);
    }


}
