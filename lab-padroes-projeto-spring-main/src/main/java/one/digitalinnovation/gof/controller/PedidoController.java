package one.digitalinnovation.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.gof.dto.PedidoRequest;
import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.Pedido;
import one.digitalinnovation.gof.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Void> criarPedido(@RequestBody PedidoRequest request) {
        Pedido pedido = new Pedido();
        pedido.setValorTotal(request.getValorTotal());

        Cliente cliente = new Cliente();
        cliente.setId(request.getClienteId());
        pedido.setCliente(cliente);

        Endereco endereco = new Endereco();
        endereco.setCep(request.getEnderecoId());
        pedido.setEnderecoEntrega(endereco);

        pedidoService.inserir(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
