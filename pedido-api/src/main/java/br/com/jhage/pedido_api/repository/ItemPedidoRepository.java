package br.com.jhage.pedido_api.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.jhage.pedido_api.modelo.ItemPedido;

public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Long>{
	

}
