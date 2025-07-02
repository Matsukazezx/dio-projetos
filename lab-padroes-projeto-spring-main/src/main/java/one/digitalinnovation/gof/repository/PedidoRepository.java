package one.digitalinnovation.gof.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import one.digitalinnovation.gof.model.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}

